package com.park.spring.security.mongodb.securitymongodb.repository;

import com.park.spring.security.mongodb.securitymongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
