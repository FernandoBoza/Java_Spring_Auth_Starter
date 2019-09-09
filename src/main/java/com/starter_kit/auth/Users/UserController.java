package com.starter_kit.auth.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
@CrossOrigin // for development purpose
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping(path = "id/{id}")
    public User findById(@PathVariable String id) {
        return userService.findById(String.valueOf(id));
    }

    @GetMapping(path = "{name}")
    public User findUserByName(@PathVariable String name) {
        return userService.findUserByName(name);
    }

}
