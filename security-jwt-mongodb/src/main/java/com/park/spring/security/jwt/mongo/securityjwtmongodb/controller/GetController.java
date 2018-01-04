package com.park.spring.security.jwt.mongo.securityjwtmongodb.controller;

import com.park.spring.security.jwt.mongo.securityjwtmongodb.PersonRepository.PersonRepository;
import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/public")
public class GetController {

    @Autowired
    private PersonRepository personRepository;

    @PermitAll
    @GetMapping("/{username}")
    public Person getPersonByUsername(@PathVariable("username") final String username) {
        return personRepository.findByUsername(username);
    }
}
