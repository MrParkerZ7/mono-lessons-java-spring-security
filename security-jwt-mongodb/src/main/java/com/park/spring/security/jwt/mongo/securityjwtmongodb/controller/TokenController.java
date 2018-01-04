package com.park.spring.security.jwt.mongo.securityjwtmongodb.controller;

import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Person;
import com.park.spring.security.jwt.mongo.securityjwtmongodb.security.JwtGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestBody final Person person) {
        return jwtGenerator.generate(person);
    }
}
