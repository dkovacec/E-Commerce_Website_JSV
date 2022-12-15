package com.brigths.Final.Countdown.Project.service;

import com.brigths.Final.Countdown.Project.model.Category;
import com.brigths.Final.Countdown.Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User addUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);

    User updateUserById(long id, User user);

    User saveUser(User user);

    List<User> getUserByEmail(String email);

    Optional<User> findByEmail(String email);
   // boolean userExists(String email);

    boolean userExists(String username);
    Optional<User> findByUsername(String username);

}
