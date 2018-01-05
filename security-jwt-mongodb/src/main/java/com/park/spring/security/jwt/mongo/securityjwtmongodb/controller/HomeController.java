package com.park.spring.security.jwt.mongo.securityjwtmongodb.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/rest")
public class HomeController {

    // By default it's ganna be permit all everyone which had role
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
