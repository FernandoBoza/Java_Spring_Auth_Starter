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

    public User createUser(User user){
        return userRepo.save(user);
    }

    public User findById(String id){
        return getFromOptional(userRepo.findById(id));
    }

    public User findUserByFirstName(String firstName){
        return userRepo.findUserByFirstName(firstName);
    }

    public User findUserByFirstNameAndLastName(String firstName, String lastName){
        return userRepo.findUserByFirstNameAndLastName(firstName, lastName);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }



}
