package com.crud.webstore.service;

import com.crud.webstore.amazon.AmazonSES;
import com.crud.webstore.domain.AddressEntity;
import com.crud.webstore.domain.UserEntity;
import com.crud.webstore.dto.AddressDto;
import com.crud.webstore.dto.UserDto;
import com.crud.webstore.web.respone.AddressResponse;
import com.crud.webstore.web.respone.ErrorMessages;
import com.crud.webstore.exception.UserNotFoundException;
import com.crud.webstore.exception.UserServiceException;
import com.crud.webstore.mapper.AddressMapper;
import com.crud.webstore.mapper.UserMapper;
import com.crud.webstore.repository.UserRepository;
import com.crud.webstore.service.impl.UtilsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserService implements UserDetailsService {
    private UserRepository repository;
    private UtilsImpl utils;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserMapper userMapper;
    private AddressMapper mapper;

    @Autowired
    public UserService(UserRepository repository, UtilsImpl utils,
                       BCryptPasswordEncoder bCryptPasswordEncoder,
                       UserMapper userMapper, AddressMapper mapper) {
        this.repository = repository;
        this.utils = utils;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userMapper = userMapper;
        this.mapper = mapper;
    }

    public UserEntity createUser(UserDto userDto) {
        findByEmail(userMapper.mapToUserEntity(userDto));

        userDto.setUserId(generatePublicId());
        userDto.setEncryptedPassword(passwordEncoder(userDto.getPassword()));
        userDto.setEmailVerificationToken(utils.generateEmailVerificationToken(userDto.getUserId()));
        userDto.setEmailVerificationStatus(false);

        List<AddressEntity> list = userDto.getAddresses().stream()
                        .map(v -> mapper.mapToAddressEntity(v))
                        .collect(Collectors.toList());

        list.forEach(v -> v.setAddressId(generatePublicId()));

        UserEntity result = repository.save(userMapper.mapToUserEntity(userDto, list));

        new AmazonSES().verifyEmail(result);

        return result;
    }

    public UserEntity findByEmail(final UserEntity userEntity) {
        if (repository.findByEmail(userEntity.getEmail()) != null) throw new RuntimeException("Record already exist");
        return userEntity;
    }

    public String generatePublicId() {
        return utils.generatePublicId(20);
    }

    public String passwordEncoder(final String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = repository.findByEmail(email);

        if (userEntity == null) throw new UsernameNotFoundException(email);

        //Switch with return below to disable EmailVerificationStatus
        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), userEntity.getEmailVerificationStatus(),
        true, true, true, new ArrayList<>());

        //return new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }

    public UserDto getUser(final String email) {

        return userMapper.mapToUserDto(repository.findByEmail(email));
    }

    public UserEntity getUserByUserId(String id) {
        UserEntity userEntity = repository.findByUserId(id);

        if (userEntity == null) {
            throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
        return userEntity;
    }

    public UserDto updateUserDetails(String id, UserDto userDto) throws Exception {
        UserEntity userEntity = repository.findByUserId(id);

        if (userEntity == null) {
            throw new UserNotFoundException();
        }

        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());

        UserEntity updatedUserDetails = repository.save(userEntity);

       return userMapper.mapToUserDto(updatedUserDetails);
    }

    public void deleteUser(String userId) {
        UserEntity userEntity = repository.findByUserId(userId);

        if (userEntity == null) {
            throw new UserServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
        }
        repository.deleteByUserId(userId);
    }

    public List<UserDto> findAll(int page, int limit) {
        if (page > 0) {
            page = page - 1;
        }

        Pageable pageableRequest = new PageRequest(page, limit);
        Page<UserEntity> usersPage = repository.findAll(pageableRequest);
        List<UserEntity> users = usersPage.getContent();

       return userMapper.mapToUserListDto(users);
    }

    public boolean verifyEmailToken(String token) {
        boolean returnValue = false;

        //Find userByToken
        UserEntity userEntity = repository.findUserEntityByEmailVerificationToken(token);

        if (userEntity != null) {
            boolean hasTokenExpired = UtilsImpl.hasTokenExpired(token);
            if (!hasTokenExpired) {
                userEntity.setEmailVerificationToken(null);
                userEntity.setEmailVerificationStatus(Boolean.TRUE);
                repository.save(userEntity);
                returnValue = true;
            }
        }

        return returnValue;
    }
}
