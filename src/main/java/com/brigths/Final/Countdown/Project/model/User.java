package com.brigths.Final.Countdown.Project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.annotations.Table;

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

    //one user can have more roles
    //one role can be given to many users
    @ManyToMany(cascade = CascadeType.MERGE, fetch  = FetchType.EAGER)
    @JoinTable(name = "user_role" , joinColumns = {@JoinColumn (name = "USER_ID", referencedColumnName = "ID")},
                inverseJoinColumn = {@JoinColumn (name = "ROLE_ID", referencedColumnName = "ID")})
    private List<Role> roles;


    public User() {

    }
    public User(User user) {
        this.id = id;
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = getRoles();
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
}
