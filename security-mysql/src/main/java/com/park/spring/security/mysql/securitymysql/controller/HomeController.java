package com.park.spring.security.mysql.securitymysql.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Home Secured";
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/profile")
    public String profile() {
        return "Home Secured";
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

    @GetMapping("/fail")
    public String fail() {
        return "Login Failed";
    }
}
