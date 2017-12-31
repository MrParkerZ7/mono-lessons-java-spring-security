package com.park.spring.security.basic.securitybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/public")
public class PublicController {

    @GetMapping
    public String park() {
        return "Public No Security";
    }
}
