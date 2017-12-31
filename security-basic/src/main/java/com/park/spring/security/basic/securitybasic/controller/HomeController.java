package com.park.spring.security.basic.securitybasic.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HomeController {

    @GetMapping("/public")
    public String park() {
        return "Public No Security";
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @GetMapping("/home")
    public String home() {
        return "Home Security || Any Authentication";
    }

    @Secured("ROLE_USER")
    @GetMapping("/user")
    public String user() {
        return "User Security || User Authentication";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/admin")
    public String admin() {
        return "Admin Security || Admin Authentication";
    }
}
