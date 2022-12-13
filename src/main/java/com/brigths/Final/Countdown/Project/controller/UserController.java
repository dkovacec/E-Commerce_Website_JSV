package com.brigths.Final.Countdown.Project.controller;

import com.brigths.Final.Countdown.Project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.brigths.Final.Countdown.Project.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){

        try{
            User newUser= userService.saveUser(new User(user.getFirstName(),user.getLastName(),user.getEmail()
                    ,user.getPassword(),user.getCountry(), user.getAddress(),user.getAddress2(),user.getPostCode(),user.getCity(), user.getPhoneNumber()));

            return new ResponseEntity<>(newUser, HttpStatus.CREATED);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String email){

        try {
            List<User> users = new ArrayList<>();

            if(email == null) {
                users = userService.getAllUsers();
            } else {
                users = userService.getUserByEmail(email);
            }

            if(users.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users,HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") long userId){
        User user = userService.getUserById(userId);

        if(user != null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping ("users/{userId}")
    public ResponseEntity<User> updateUserById (@PathVariable("userId") long userId, @RequestBody User user){

       User updateUser = userService.updateUserById(userId,user);

        if(updateUser != null){
            return new ResponseEntity<>(userService.saveUser(updateUser),HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("users/{userId}")
    public ResponseEntity<User> deleteUserById (@PathVariable ("userId") long userId){
        try {
            userService.deleteUserById(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
