package com.park.spring.security.jwt.mongo.securityjwtmongodb.PersonRepository;


import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, String> {
    Optional<Person> findByUsername(String username);
}
