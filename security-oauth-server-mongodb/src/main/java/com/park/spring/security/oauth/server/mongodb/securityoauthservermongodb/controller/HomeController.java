package com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/rest/home")
public class HomeController {

    @GetMapping("/principal")
    public Principal principal(Principal principal) {
        return principal;
    }

    @GetMapping
    public String home() {
        return "Home Server!!";
    }
}
