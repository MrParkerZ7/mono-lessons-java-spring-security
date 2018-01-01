package com.park.spring.security.jwt.securityjwt.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String token;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return null; // TODO: Just for demo
    }

    @Override
    public Object getPrincipal() {
        return null;  // TODO: Just for demo
    }
}
