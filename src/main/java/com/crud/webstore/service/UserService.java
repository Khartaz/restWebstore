package com.crud.webstore.service;

import com.crud.webstore.domain.UserEntity;
import com.crud.webstore.domain.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserEntity save(final UserEntity userEntity);

    UserEntity findByEmail(final UserEntity userEntity);

    String generateUserId();

    String passwordEncoder(String password);

    UserDto getUser(String userName);
}
