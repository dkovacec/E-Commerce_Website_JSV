package com.brigths.Final.Countdown.Project.service;

import com.brigths.Final.Countdown.Project.model.Category;
import com.brigths.Final.Countdown.Project.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User addUser(User user);

    User getUserById(long id);

    void deleteUserById(long id);

    User updateUserById(long id, User user);

    User saveUser(User user);

    List<User> getUserByEmail(String email);
}
