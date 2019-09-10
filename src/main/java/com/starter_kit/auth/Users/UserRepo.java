package com.starter_kit.auth.Users;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    User findUserByName(String name);
    User findUserByEmail(String email);
}
