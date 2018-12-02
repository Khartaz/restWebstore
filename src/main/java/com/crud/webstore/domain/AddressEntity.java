package com.crud.webstore.domain;

import javax.persistence.*;

@Entity(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "ADDRESS_ID")
    private String addressId;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity userEntity;

    public AddressEntity() {
    }

    public AddressEntity(String addressId, String city,
                         String country, String streetName,
                         String postalCode, String type) {
        this.addressId = addressId;
        this.city = city;
        this.country = country;
        this.streetName = streetName;
        this.postalCode = postalCode;
        this.type = type;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
