package com.starter_kit.auth.Users;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    public User findUserByName(String name);
    public User findUserByEmail(String email);
}
