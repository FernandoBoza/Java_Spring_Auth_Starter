package com.starter_kit.auth.Auth;

import com.starter_kit.auth.Users.User;
import com.starter_kit.auth.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/login")
    public String login() { return "Login Page"; }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserDetails login(@RequestBody User user) {
        return userService.loadUserByUsername(user.getEmail());
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping(path = "/register")
    public String createUser() {  return "Register Page"; }

    @GetMapping(path = "/dashboard")
    public User forwardToDashboard(){
        System.out.println("passed");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.findUserByEmail(auth.getName());
    }

    @GetMapping(path = "")
    public String home(){
        return "home index";
    }

}
