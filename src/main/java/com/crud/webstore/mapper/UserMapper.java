package com.crud.webstore.mapper;

import com.crud.webstore.domain.UserEntity;
import com.crud.webstore.domain.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity mapToUser(final UserDto userDto) {
        return new UserEntity(
                userDto.getUserId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getEncryptedPassword()
        );
    }

    public UserDto mapToUserDto(final UserEntity userEntity) {
        return new UserDto(
                userEntity.getUserId(),
                userEntity.getFirstName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getEncryptedPassword()
        );
    }
}