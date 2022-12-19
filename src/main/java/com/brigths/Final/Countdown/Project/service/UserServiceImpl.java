package com.brigths.Final.Countdown.Project.service;

import com.brigths.Final.Countdown.Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brigths.Final.Countdown.Project.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {

        User newUser = userRepository.save(user);

        return newUser;
    }


    @Override
    public User updateUserById(long id, User user) {
        User userData = getUserById(id);
        if (userData != null) {
            userData.setLastName(user.getLastName());
            userData.setFirstName(user.getFirstName());
            userData.setEmail(user.getEmail());
            userData.setPassword(user.getPassword());
            userData.setCountry(user.getCountry());
            userData.setAddress(user.getAddress());
            userData.setAddress2(user.getAddress2());
            userData.setPostCode(user.getPostCode());
            userData.setCity(user.getCity());
            userData.setPhoneNumber(user.getPhoneNumber());
            return userData;
        }
        return null;
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
    public List<User> getUserByEmail(String email) {
        return userRepository.getByEmailContainingIgnoreCase(email);
    }

    public Optional<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public Optional<User> findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public boolean userExists(String username) {
        return this.userRepository.existsByUsernameIgnoreCase(username);
    }
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
    public Optional<User> findById(Long userId) {
        return this.userRepository.findById(userId);
    }
    @Override
    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }
    public User save(User user) {
        return this.userRepository.save(user);
    }
    @Override
    public void deleteUserById(long id) {
        boolean exists = this.userRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("User with id " + id + " was not found.");
        }
        this.userRepository.deleteById(id);
    }
}