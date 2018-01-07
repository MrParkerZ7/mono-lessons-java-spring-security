package com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.repository;


import com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
