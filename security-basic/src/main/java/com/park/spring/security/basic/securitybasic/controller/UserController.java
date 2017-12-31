package com.park.spring.security.basic.securitybasic.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/user")
public class UserController {

    @Secured("ROLE_USER")
    @GetMapping
    public String user() {
        return "User Security || User Authentication";
    }
}
