package com.crud.webstore.controller;

import com.crud.webstore.domain.dto.UserDto;
import com.crud.webstore.mapper.UserMapper;
import com.crud.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public String getUser() {
        return "get user was called";
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto)  {
        userDto.setUserId(service.generateUserId());
        service.findByEmail(userMapper.mapToUser(userDto));
        userDto.setEncryptedPassword(service.passwordEncoder(userMapper.mapToUser(userDto)));
        service.saveUser(userMapper.mapToUser(userDto));
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

