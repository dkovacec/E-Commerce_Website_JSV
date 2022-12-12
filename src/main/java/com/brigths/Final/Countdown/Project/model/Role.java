package com.brigths.Final.Countdown.Project.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Table;

import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    //one user can have more roles
    //one role can be given to many users
    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
