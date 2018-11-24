package com.crud.webstore.service;

import com.crud.webstore.domain.User;
import com.crud.webstore.repository.UserRepository;
import com.crud.webstore.service.impl.UtilsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
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

    public String passwordEncoder(User user) {
        return bCryptPasswordEncoder.encode(user.getPassword());
    }
}
