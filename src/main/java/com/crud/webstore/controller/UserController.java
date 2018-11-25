package com.crud.webstore.controller;

import com.crud.webstore.domain.dto.UserDto;
import com.crud.webstore.mapper.UserMapper;
import com.crud.webstore.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserServiceImpl service;

    @RequestMapping(method = RequestMethod.GET)
    public String getUser() {
        return "get user was called";
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public @ResponseBody UserDto createUser(@RequestBody UserDto userDto) {
        userDto.setUserId(service.generateUserId());
        service.findByEmail(userMapper.mapToUser(userDto));
        String password = userDto.getPassword();
        userDto.setEncryptedPassword(service.passwordEncoder(password));
        service.saveUser(userMapper.mapToUser(userDto));

        return userDto;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateUser() {
        return "update user was called";
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteUser() {
        return "delete user was called";
    }
}

