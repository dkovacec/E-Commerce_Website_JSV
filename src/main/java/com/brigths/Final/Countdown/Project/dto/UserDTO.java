package com.brigths.Final.Countdown.Project.dto;

import com.brigths.Final.Countdown.Project.model.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class UserDTO {

    private Long id;
    private String username;

    private boolean admin;
    private String firstName;
    private String lastName;

    private String email;

    private String country;
    private String address;
    private String address2;
    private String postCode;
    private String city;
    private String phoneNumber;


    public static UserDTO fromEntity(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.id = user.getId();
        userDTO.username = user.getUsername();
        userDTO.firstName = user.getFirstName();
        userDTO.lastName = user.getLastName();
        userDTO.city = user.getCity();
        userDTO.country = user.getCountry();
        userDTO.postCode = user.getPostCode();
        userDTO.address = user.getAddress();
        userDTO.address2 = user.getAddress2();
        userDTO.email = user.getEmail();
        userDTO.phoneNumber = user.getPhoneNumber();
        userDTO.admin = user.isAdmin();
        return userDTO;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isAdmin() {
        return admin;
    }
}
