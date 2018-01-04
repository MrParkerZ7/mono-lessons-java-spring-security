package com.park.spring.security.jwt.mongo.securityjwtmongodb.security;

import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Person;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class JwtValidator {

    //​ Key to Encrypt
    private String secret = "ParkZ7";

    public Person validate(String token) {

        Person person = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            person = new Person();

            person.setUsername(body.getSubject());
            person.setPassword((String) body.get("password"));
            person.setId((String) body.get("id"));
            person.setRole((Collection<String>) body.get("role"));
        } catch (Exception e) {
            System.out.println(e);
        }

        return person;
    }
}
