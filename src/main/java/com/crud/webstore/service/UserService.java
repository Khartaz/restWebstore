package com.crud.webstore.service;

import com.crud.webstore.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User saveUser(final User user);

    User findByEmail(final User user);

    String generateUserId();

    String passwordEncoder(String password);
}
