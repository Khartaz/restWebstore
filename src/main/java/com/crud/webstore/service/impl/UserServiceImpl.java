package com.crud.webstore.service.impl;

import com.crud.webstore.domain.User;
import com.crud.webstore.repository.UserRepository;
import com.crud.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UtilsImpl utils;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(final User user) {
        return repository.save(user);
    }

    public User findByEmail(final User user) {
        if (repository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exist");
        return user;
    }

    public String generateUserId() {
        return utils.generateUserId(20);
    }

    public String passwordEncoder(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
