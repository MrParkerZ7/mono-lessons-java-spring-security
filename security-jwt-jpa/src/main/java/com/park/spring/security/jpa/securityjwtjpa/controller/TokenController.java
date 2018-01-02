package com.park.spring.security.jpa.securityjwtjpa.controller;

import com.park.spring.security.jpa.securityjwtjpa.model.Person;
import com.park.spring.security.jpa.securityjwtjpa.security.JwtGenerator;
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

    @PostMapping("/person")
    public String generate(@RequestBody final Person person) {
        return jwtGenerator.generate(person);
    }
}
