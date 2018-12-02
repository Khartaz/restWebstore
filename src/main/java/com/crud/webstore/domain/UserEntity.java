package com.crud.webstore.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    private String password;

    @Column(name = "ENCRYPTED_PASSWORD")
    private String encryptedPassword;


    @OneToMany(
            //targetEntity = AddressEntity.class,
            mappedBy = "userEntity",
            cascade = CascadeType.ALL
            //fetch = FetchType.LAZY
    )
    private List<AddressEntity> addressEntityList = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(String userId, String firstName, String lastName,
                      String email, String encryptedPassword) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AddressEntity> getAddressEntityList() {
        return addressEntityList;
    }

    public void setAddressEntityList(List<AddressEntity> addressEntityList) {
        this.addressEntityList = addressEntityList;
    }
}
