package com.crud.webstore.service;

import com.crud.webstore.domain.UserEntity;
import com.crud.webstore.domain.dto.UserDto;
import com.crud.webstore.repository.UserRepository;
import com.crud.webstore.service.impl.UtilsImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class UserService implements UserDetailsService {
    

    @Autowired
    private UserRepository repository;
    @Autowired
    private UtilsImpl utils;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserEntity save(final UserEntity userEntity) {
        return repository.save(userEntity);
    }

    public UserEntity findByEmail(final UserEntity userEntity) {
        if (repository.findByEmail(userEntity.getEmail()) != null) throw new RuntimeException("Record already exist");
        return userEntity;
    }

    public String generateUserId() {
        return utils.generateUserId(20);
    }

    public String passwordEncoder(final String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = repository.findByEmail(email);

        if (userEntity == null) throw new UsernameNotFoundException(email);

        return new org.springframework.security.core.userdetails.User
                (userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }

    public UserDto getUser(final String email) {
        UserEntity userEntity = repository.findByEmail(email);
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(userEntity, returnValue);

        return returnValue;
    }

}
