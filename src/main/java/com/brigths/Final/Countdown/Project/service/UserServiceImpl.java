package com.brigths.Final.Countdown.Project.service;

import com.brigths.Final.Countdown.Project.model.User;
import org.springframework.stereotype.Service;
import com.brigths.Final.Countdown.Project.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;

        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
        return user;
    }

    @Override
    public void deleteUserById(long id) {
        boolean exists = this.userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User with id " + id + " was not found.");
        }
        this.userRepository.deleteById(id);
    }

    @Override
    public User updateUserById(long id, User user) {
        User userData = getUserById(id);
        if (userData != null) {
            userData.setLastName(user.getLastName());
            userData.setFirstName(user.getFirstName());
            userData.setEmail(user.getEmail());


            return userData;
        }
        return null;
    }

    @Override
    public User saveUser(User user) {
        User newUser = userRepository.save(user);

        return newUser;
    }

    @Override
    public List<User> getUserByEmail(String email) {
        return userRepository.findByEmailContainingIgnoreCase(email);
    }

    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }
}