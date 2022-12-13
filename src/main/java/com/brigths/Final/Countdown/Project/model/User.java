package com.brigths.Final.Countdown.Project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String firstName;

    private String lastName;

    @NotEmpty
    @Column(nullable = false, unique = true)  //one user one email rule
    private String email;

    @NotEmpty
    private String password;

    private String country;
    private String address;
    private String address2;
    private String postCode;
    private String city;
    private String phoneNumber;


    //one user can have more roles
    //one role can be given to many users
    @ManyToMany(cascade = CascadeType.MERGE, fetch  = FetchType.EAGER)
    @JoinTable(name = "user_role" , joinColumns = {@JoinColumn (name = "USER_ID", referencedColumnName = "ID")},
                inverseJoinColumns = {@JoinColumn (name = "ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;


    public User(String firstName, String lastName, String email, String password, String country, String address, String address2, String postCode, String city, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.country = country;
        this.address = address;
        this.address2 = address2;
        this.postCode = postCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }

    public User() {

    }

    public User(String firstName, String lastName, String email, String password, String address, String address2, String city, String country, String postCode, String phoneNumber) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
