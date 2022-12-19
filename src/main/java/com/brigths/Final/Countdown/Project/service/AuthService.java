package com.brigths.Final.Countdown.Project.service;



import com.brigths.Final.Countdown.Project.dto.RegistrationDTO;
import com.brigths.Final.Countdown.Project.exception.UsernameTakenException;
import com.brigths.Final.Countdown.Project.jwt.JWTUtil;
import com.brigths.Final.Countdown.Project.model.User;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final static int COOKIE_AGE_24H = 24 * 60 * 60;

    private final AuthenticationManager authenticationManager;

    private final JWTUtil jwtUtil;
    private final UserService userService;

    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.cookieName}")
    private String jwtCookieName;

    public AuthService(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserService userService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public User authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        return this.userService.findByUsername(authentication.getName()).orElseThrow();
    }

    public Cookie createTokenCookie(String username) {
        String token = jwtUtil.generateToken(username);

        Cookie cookie = new Cookie(jwtCookieName, token);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(COOKIE_AGE_24H);
        cookie.setPath("/");
        return cookie;
    }

    public User register(RegistrationDTO registrationDTO) {
        if (userService.userExists(registrationDTO.getUsername())) {
            throw new UsernameTakenException(registrationDTO.getUsername());
        }

        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setLastName(registrationDTO.getLastName());
        user.setFirstName(registrationDTO.getFirstName());
        user.setCity(registrationDTO.getCity());
        user.setCountry(registrationDTO.getCountry());
        user.setAddress (registrationDTO.getAddress());
        user.setAddress2(registrationDTO.getAddress2());
        user.setPostCode(registrationDTO.getPostCode());
        user.setPhoneNumber(registrationDTO.getPhoneNumber());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword1()));

        user.setAdmin(false);
        return this.userService.save(user);
    }
}