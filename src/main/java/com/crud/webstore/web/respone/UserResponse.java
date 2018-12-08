package com.crud.webstore.web.respone;

import com.crud.webstore.dto.AddressDto;

import java.util.List;

public class UserResponse<T> {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<AddressDto> addresses;

    public UserResponse() {
    }


    public UserResponse(String userId, String firstName, String lastName, String email, List<AddressDto> addresses) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addresses = addresses;
    }

    public UserResponse(String userId, String firstName,
                        String lastName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserResponse(Object message, Object httpHeaders, Object internalServerError) {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AddressDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDto> addresses) {
        this.addresses = addresses;
    }
}
