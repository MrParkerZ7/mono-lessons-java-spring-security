package com.park.spring.security.jwt.mongo.securityjwtmongodb.PersonRepository;


import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, String> {
    Person findByUsername(String username);
}
