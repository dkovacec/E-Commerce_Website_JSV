package com.brigths.Final.Countdown.Project.service;

import com.brigths.Final.Countdown.Project.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import static java.lang.String.format;

@Service
public class SecurityService implements UserDetailsService {

    private final UserService userService;

    public SecurityService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(format("Username '%s' not found", username)));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), List.of());
    }
}
