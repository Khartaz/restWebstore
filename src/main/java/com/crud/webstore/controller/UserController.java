package com.crud.webstore.controller;

import com.crud.webstore.domain.dto.UserDto;
import com.crud.webstore.domain.respone.UserResponse;
import com.crud.webstore.exception.UserNotFoundException;
import com.crud.webstore.mapper.UserMapper;
import com.crud.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService service;

    @GetMapping(value = "id")
    public UserResponse getUser(@RequestParam String id) throws UserNotFoundException {
        return userMapper.mapToUserResponse(
                 userMapper.mapToUserDto(service.getUserByUserId(id).orElseThrow(UserNotFoundException::new))
         );
    }

    @PostMapping(value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public @ResponseBody UserDto createUser(@RequestBody UserDto userDto) {
        userDto.setUserId(service.generateUserId());
        service.findByEmail(userMapper.mapToUserEntity(userDto));
        String password = userDto.getPassword();
        userDto.setEncryptedPassword(service.passwordEncoder(password));
        service.save(userMapper.mapToUserEntity(userDto));

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

