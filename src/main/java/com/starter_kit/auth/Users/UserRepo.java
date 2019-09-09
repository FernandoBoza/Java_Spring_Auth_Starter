package com.starter_kit.auth.Users;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    public User findUserByFirstName(String firstName);
    public User findUserByFirstNameAndLastName(String firstName, String lastName);
}
