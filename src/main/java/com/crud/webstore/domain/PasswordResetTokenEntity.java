package com.crud.webstore.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PASSWORD_RESET_TOKENS")
public class PasswordResetTokenEntity implements Serializable {
    private static final long serialVersionUID = 805134316462897L;

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "TOKEN")
    private String token;

    @OneToOne
    private UserEntity userEntity;

    public PasswordResetTokenEntity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
