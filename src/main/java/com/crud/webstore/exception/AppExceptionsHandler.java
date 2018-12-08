package com.crud.webstore.exception;

import com.crud.webstore.web.respone.ErrorMessage;
import com.crud.webstore.web.respone.UserResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionsHandler {


    //Specific Exception
    @ExceptionHandler(value = {UserServiceException.class})
    public UserResponse<Object> handlerUserServiceException(UserServiceException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());

        return new UserResponse<>(errorMessage, new  HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*
    //All Others Example
    @ExceptionHandler(value = {Exception.class})
    public UserResponse<Object> handlerOtherExceptions(Exception ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), ex.getMessage());

        return new UserResponse<>(errorMessage, new  HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    */
}
