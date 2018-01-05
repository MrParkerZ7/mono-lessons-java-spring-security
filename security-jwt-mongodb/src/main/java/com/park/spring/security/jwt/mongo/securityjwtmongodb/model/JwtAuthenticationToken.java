package com.park.spring.security.jwt.mongo.securityjwtmongodb.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String token;
    private String credentials;
    private String principal;

    public JwtAuthenticationToken(String token) {
        super(null, null);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return null; // TODO: Should do more
    }

    @Override
    public Object getPrincipal() {
        return null;  // TODO: Should do more
    }
}
