package com.park.spring.security.jpa.securityjwtjpa.security;

import com.park.spring.security.jpa.securityjwtjpa.Repository.PersonRepository;
import com.park.spring.security.jpa.securityjwtjpa.model.Person;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Component
public class JwtValidator {

    // Key to Encrypt
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
            person.setId(Integer.valueOf((String) body.get("Id")));
            person.setPassword((String) body.get("password"));
            person.setRole((Collection<String>) body.get("role"));
        } catch (Exception e) {
            System.out.println(e);
        }

        return person;
    }
}
