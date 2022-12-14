package com.brigths.Final.Countdown.Project.service;

import com.brigths.Final.Countdown.Project.dto.UserDTO;
import com.brigths.Final.Countdown.Project.model.Category;
import com.brigths.Final.Countdown.Project.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    User addUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);

    User updateUserById(long id, UserDTO userDTO);

    User saveUser(User user);

    List<User> getUserByEmail(String email);

    Optional<User> findByEmail(String email);
    Optional<User> findById(Long userId);
   // boolean userExists(String email);

    boolean userExists(String username);
    Optional<User> findByUsername(String username);

    User save(User user);

}
