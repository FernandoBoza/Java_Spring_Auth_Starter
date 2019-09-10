package com.starter_kit.auth.Auth;

import com.starter_kit.auth.Users.User;
import com.starter_kit.auth.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDetails login(@RequestBody User user) {
        return userService.loadUserByUsername(user.getEmail());
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping(path = "/dashboard")
    public User forwardToDashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.findUserByEmail(auth.getName());
    }

    @GetMapping(path = "/dashboard/user")
    public User forwardToUserDashboard() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.findUserByEmail(auth.getName());
    }

}
