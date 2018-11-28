package com.crud.webstore.controller;

import com.crud.webstore.domain.dto.UserDto;
import com.crud.webstore.domain.respone.ErrorMessages;
import com.crud.webstore.domain.respone.UserResponse;
import com.crud.webstore.exception.UserNotFoundException;
import com.crud.webstore.exception.UserServiceException;
import com.crud.webstore.mapper.UserMapper;
import com.crud.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService service;

    @GetMapping(value = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getUser(@RequestParam String id) throws UserNotFoundException {
        return userMapper.mapToUserResponse(
                 userMapper.mapToUserDto(service.getUserByUserId(id).orElseThrow(UserNotFoundException::new))
         );
    }

    @PostMapping(value = "createUser",
            consumes = MediaType.APPLICATION_JSON_VALUE ,
            produces = MediaType.APPLICATION_JSON_VALUE
            )
    public @ResponseBody UserResponse createUser(@RequestBody UserDto userDto) {
        if (userDto.getFirstName().isEmpty())
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        return userMapper.mapToUserResponse(userMapper.mapToUserDto(service.save(userDto)));
    }

    @PutMapping(value = "updateUserDetails",
            consumes = MediaType.APPLICATION_JSON_VALUE ,
            produces = MediaType.APPLICATION_JSON_VALUE
            )
    public UserResponse updateUser(@RequestBody UserDto userDto, @RequestParam String id) throws Exception {
        return userMapper.mapToUserResponse(service.updateUserDetails(id, userDto));
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}

