package com.crud.webstore.domain.respone;

import com.crud.webstore.domain.AddressEntity;

import java.util.List;

public class UserResponse<T> {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<AddressEntity> addressResponseList;

    public UserResponse() {
    }

    public UserResponse(String userId, String firstName,
                        String lastName, String email,
                        List<AddressEntity> addressResponseList) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.addressResponseList = addressResponseList;
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

    public List<AddressEntity> getAddressResponseList() {
        return addressResponseList;
    }

    public void setAddressResponseList(List<AddressEntity> addressResponseList) {
        this.addressResponseList = addressResponseList;
    }
}
