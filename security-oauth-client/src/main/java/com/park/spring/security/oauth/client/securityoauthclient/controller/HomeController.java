package com.park.spring.security.oauth.client.securityoauthclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "Home Client!!";
    }

    @GetMapping("/user")
    public String user() {
        return "User Client!!";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin Client!!";
    }
}
