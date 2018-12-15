package com.crud.webstore.service;

import com.crud.webstore.domain.UserEntity;

public interface EmailService {

    void sendVerificationEmail(UserEntity userEntity);

    boolean sendPasswordResetRequest(String firstName, String email, String token);

}
