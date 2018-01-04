package com.park.spring.security.jwt.mongo.securityjwtmongodb.controller;

import com.park.spring.security.jwt.mongo.securityjwtmongodb.PersonRepository.PersonRepository;
import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/rest")
public class HomeController {

    @Autowired
    private PersonRepository personRepository;

    @PermitAll
    @GetMapping("/{username}")
    public Person getPersonByUsername(@PathVariable("username") final String username) {
        return personRepository.findByUsername(username);
    }

    @GetMapping("/home")
    public String home() {
        return "Home JWT";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/profile")
    public String profile() {
        return "Profile Secured";
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/user")
    public String user() {
        return "User Secured";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "Admin Secured";
    }

}
