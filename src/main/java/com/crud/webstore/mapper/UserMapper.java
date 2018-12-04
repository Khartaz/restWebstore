package com.crud.webstore.mapper;

import com.crud.webstore.domain.AddressEntity;
import com.crud.webstore.domain.UserEntity;
import com.crud.webstore.domain.dto.AddressDto;
import com.crud.webstore.domain.dto.UserDto;
import com.crud.webstore.domain.respone.AddressResponse;
import com.crud.webstore.domain.respone.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
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
                userEntity.getEncryptedPassword()
        );
    }

    public UserResponse mapToUserResponse(UserDto userDto) {
        return new UserResponse(
                userDto.getUserId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()
        );
    }

    public List<UserResponse> mapToUserListResponse(List<UserDto> userDto) {
        return userDto.stream()
                .map(u -> new UserResponse(u.getUserId(), u.getFirstName(), u.getLastName(), u.getEmail()))
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
