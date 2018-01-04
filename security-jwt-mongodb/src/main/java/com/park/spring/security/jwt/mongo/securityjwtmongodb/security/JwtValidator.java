package com.park.spring.security.jwt.mongo.securityjwtmongodb.security;

import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Person;
import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Status;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedHashMap;

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
            LinkedHashMap<String, Boolean> status = (LinkedHashMap<String, Boolean>) body.get("status");

            person.setUsername(body.getSubject());
            person.setPassword((String) body.get("password"));
            person.setId((String) body.get("id"));
            person.setStatus(
                    new Status(
                            status.get("accountNonExpired"),
                            status.get("accountNonLocked"),
                            status.get("credentialsNonExpired"),
                            status.get("enable")));
            person.setRole((Collection<String>) body.get("role"));
        } catch (Exception e) {
            System.out.println(e);
        }

        return person;
    }
}
