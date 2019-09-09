package com.starter_kit.auth.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.starter_kit.auth.Utils.*;


@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) { return userRepo.save(user); }

    public User findById(String id) { return getFromOptional(userRepo.findById(id)); }

    public User findUserByName(String name) { return userRepo.findUserByName(name); }

    public List<User> findAllUsers() { return userRepo.findAll(); }

}
