package com.crud.webstore.security;

import com.crud.webstore.SpringApplicationContext;

public class SecurityConstans {
    public static final long EXPIRATION_TIME = 864000000; //10 days
    public static final long PASSWORD_RESET_EXPIRATION_TIME = 3600000; //1hour
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String USER_ID = "userId";
    public static final String SIGN_UP_URL = "/v1/users/createUser";
    public static final String VERIFICATION_EMAIL_URL = "/v1/users/email-verification";
    public static final String EMAIL_VERIFICATION_STATUS_URL = "/v1/users/check-email-status";
    public static final String PASSWORD_RESET_REQUEST_URL = "/v1/users/password-reset-request";
    public static final String PASSWORD_RESET_URL = "/v1/users/password-reset";
    public static final String[] SWAGGER = {
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    public static String getTokenSecret() {
        AppProperties appProperties = (AppProperties) SpringApplicationContext.getBean("appProperties");
        return appProperties.getTokenSecret();
    }
}