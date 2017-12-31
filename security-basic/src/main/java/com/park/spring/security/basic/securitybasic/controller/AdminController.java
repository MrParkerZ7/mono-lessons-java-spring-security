package com.park.spring.security.basic.securitybasic.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/admin")
public class AdminController {

    @Secured("ROLE_ADMIN")
    @GetMapping
    public String admin() {
        return "Admin Security || Admin Authentication";
    }
}
