package com.park.spring.security.jwt.mongo.securityjwtmongodb.security;

import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Person;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    public String generate(Person person) {
        Claims claims = Jwts.claims().setSubject(person.getUsername());
        claims.put("password",person.getPassword());
        claims.put("id", person.getId());
        claims.put("status",person.getStatus()); // "status" is object type Student. But, when it generate it back it will become a LinkHashList
        claims.put("role", person.getRole());


        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "ParkZ7")
                .compact();
    }
}
