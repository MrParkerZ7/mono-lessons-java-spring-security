package com.park.spring.security.jpa.securityjwtjpa.security;

import com.park.spring.security.jpa.securityjwtjpa.model.JwtAuthenticationToken;
import com.park.spring.security.jpa.securityjwtjpa.model.Person;
import com.park.spring.security.jpa.securityjwtjpa.model.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtValidator validator;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();

        Person person = validator.validate(token);

        if (person == null) {
            throw new RuntimeException("Jwt Token is incorrect");
        }

        List<String> grantedAuthorities = new ArrayList<>(person.getRole());
        return new PersonDetails( token,person.getId(),person.getUsername(),person.getPassword(),person.getStatus(), grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
