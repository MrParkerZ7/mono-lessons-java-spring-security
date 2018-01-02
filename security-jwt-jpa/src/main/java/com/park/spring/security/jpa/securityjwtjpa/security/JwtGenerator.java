package com.park.spring.security.jpa.securityjwtjpa.security;

import com.park.spring.security.jpa.securityjwtjpa.model.Person;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    public String generate(Person person) {
        Claims claims = Jwts.claims().setSubject(person.getUsername());
        claims.put("id", String.valueOf(person.getId()));
        claims.put("password", person.getPassword());
        claims.put("role", person.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.ES384, "ParkZ7")
                .compact();
    }
}
