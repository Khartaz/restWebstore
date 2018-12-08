package com.crud.webstore.mapper;

import com.crud.webstore.domain.AddressEntity;
import com.crud.webstore.domain.UserEntity;
import com.crud.webstore.dto.AddressDto;
import com.crud.webstore.dto.UserDto;
import com.crud.webstore.web.respone.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private AddressMapper addressMapper;
    @Autowired
    public void setAddressMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public UserEntity mapToUserEntity(UserDto userDto) {
        return new UserEntity(
                userDto.getUserId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getEncryptedPassword()
        );
    }

    public UserEntity mapToUserEntity(UserDto userDto, List<AddressEntity> list) {
        UserEntity userEntity = mapToUserEntity(userDto);
        userEntity.setAddressEntityList(list);

        return userEntity;
    }

    public UserDto mapToUserDto(UserEntity userEntity) {
        return new UserDto(
                userEntity.getUserId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getEncryptedPassword(),
                userEntity.getAddressEntityList()
                        .stream()
                        .map(v -> addressMapper.mapToAddressDto(v))
                        .collect(Collectors.toList())
        );
    }

    public UserResponse mapToUserResponse(UserDto userDto) {
        return new UserResponse(
                userDto.getUserId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getAddresses()
        );
    }

    public List<UserResponse> mapToUserListResponse(List<UserDto> userDto) {
        return userDto.stream()
                .map(u -> new UserResponse(u.getUserId(), u.getFirstName(), u.getLastName(), u.getEmail(),
                        u.getAddresses()))
                .collect(Collectors.toList());
    }

    public List<UserDto> mapToUserListDto(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(u -> new UserDto(u.getUserId(),
                        u.getFirstName(),
                        u.getLastName(),
                        u.getEmail(),
                        u.getEncryptedPassword()))
                .collect(Collectors.toList());
    }

}
