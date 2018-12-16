package com.crud.webstore.web.controller;

import com.crud.webstore.domain.UserEntity;
import com.crud.webstore.dto.UserDto;
import com.crud.webstore.repository.UserRepository;
import com.crud.webstore.web.request.PasswordReset;
import com.crud.webstore.web.request.PasswordResetRequest;
import com.crud.webstore.web.request.RequestOperationNames;
import com.crud.webstore.web.respone.*;
import com.crud.webstore.exception.UserServiceException;
import com.crud.webstore.mapper.UserMapper;
import com.crud.webstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {
    private UserMapper userMapper;
    private UserService service;

    @Autowired
    public UserController(UserMapper userMapper, UserService service) {
        this.userMapper = userMapper;
        this.service = service;
    }

    //Change to PathVariable?
    @GetMapping(value = "id", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getUser(@RequestParam String id) {
        return userMapper.mapToUserResponse(
                 userMapper.mapToUserDto(service.getUserByUserId(id)));
    }

    @PostMapping(value = "createUser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
            )
    public @ResponseBody UserResponse createUser(@RequestBody UserDto userDto) {
        if (userDto.getFirstName().isEmpty())
            throw new UserServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());

        return userMapper.mapToUserResponse(userMapper.mapToUserDto(service.createUser(userDto)));
    }

    @PutMapping(value = "updateUserDetails",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
            )
    public UserResponse updateUser(@RequestBody UserDto userDto, @RequestParam String id) throws Exception {
        return userMapper.mapToUserResponse(service.updateUserDetails(id, userDto));
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public OperationStatus deleteUser(@RequestParam String id) {
        OperationStatus result = new OperationStatus();

        result.setOperationName(RequestOperationNames.DELETE.name());

        service.deleteUser(id);

        result.setOperationResult(RequestOperationStatus.SUCCESS.name());
        return result;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserResponse> getUsers(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "25") int limit) {
        return userMapper.mapToUserListResponse(service.findAll(page, limit));
    }

    @GetMapping(value = "/email-verification", produces = MediaType.APPLICATION_JSON_VALUE)
    public OperationStatus verifyEmailToken(@RequestParam(value = "token") String token) {

        OperationStatus returnValue = new OperationStatus();
        returnValue.setOperationName(RequestOperationNames.VERIFY_EMAIL.name());

        boolean isVerified = service.verifyEmailToken(token);

        if (isVerified) {
            returnValue.setOperationResult(RequestOperationStatus.VERIFIED.name());
        } else {
            returnValue.setOperationResult(RequestOperationStatus.ERROR.name());
        }
        return returnValue;
    }

    @GetMapping(value = "/check-email-status", produces = MediaType.APPLICATION_JSON_VALUE)
    public OperationStatus checkEmailStatus(@RequestParam String userId) {
        UserEntity userEntity = service.getUserByUserId(userId);
        OperationStatus result = new OperationStatus();
        result.setOperationName(RequestOperationNames.CHECK_EMAIL_VERIFICATION_STATUS.name());
        Boolean isVerified = userEntity.getEmailVerificationStatus();

        if (isVerified)  {
            result.setOperationResult(RequestOperationStatus.VERIFIED.name());
        } else {
            result.setOperationResult(RequestOperationStatus.NOT_VERIFIED.name());
        }
        return result;
    }

    @PostMapping(value = "/password-reset-request",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public OperationStatus requestReset(@RequestBody PasswordResetRequest passwordResetRequest) {
        OperationStatus returnValue = new OperationStatus();

        boolean operationResult = service.requestPasswordReset(passwordResetRequest.getEmail());

        returnValue.setOperationName(RequestOperationNames.REQUEST_PASSWORD_RESET.name());
        returnValue.setOperationResult(RequestOperationStatus.ERROR.name());

        if (operationResult) {
            returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        }

        return returnValue;
    }

    @PostMapping(path = "/password-reset", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OperationStatus resetPassword(@RequestBody PasswordReset passwordReset) {
        OperationStatus returnValue = new OperationStatus();

        boolean operationResult = service.resetPassword(
                passwordReset.getToken(),
                passwordReset.getPassword());

        returnValue.setOperationName(RequestOperationNames.PASSWORD_RESET.name());
        returnValue.setOperationResult(RequestOperationStatus.ERROR.name());

        if (operationResult) {
            returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
        }

        return returnValue;
    }

}

