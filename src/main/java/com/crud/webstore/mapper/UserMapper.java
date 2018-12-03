package com.crud.webstore.mapper;

import com.crud.webstore.domain.UserEntity;
import com.crud.webstore.domain.dto.UserDto;
import com.crud.webstore.domain.respone.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserEntity mapToUserEntity(final UserDto userDto) {
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

    public UserResponse mapToUserResponse(final UserDto userDto) {
        return new UserResponse(
                userDto.getUserId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getAddresses()
        );
    }

    public List<UserResponse> mapToUserListResponse(final List<UserDto> userDto) {
        return userDto.stream()
                .map(u -> new UserResponse(u.getUserId(), u.getFirstName(), u.getLastName(), u.getEmail(), u.getAddresses()))
                .collect(Collectors.toList());
    }

    public List<UserDto> mapToUserListDto(final List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(u -> new UserDto(u.getUserId(),
                        u.getFirstName(),
                        u.getLastName(),
                        u.getEmail(),
                        u.getEncryptedPassword()))
                .collect(Collectors.toList());
    }
}
