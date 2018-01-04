package com.park.spring.security.jwt.mongo.securityjwtmongodb.service;

import com.park.spring.security.jwt.mongo.securityjwtmongodb.PersonRepository.PersonRepository;
import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.CustomPersonDetails;
import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> optionalPerson = Optional.ofNullable(personRepository.findByUsername(username));

        optionalPerson.orElseThrow(() -> new RuntimeException("Username not found!!"));
        return optionalPerson
                .map(CustomPersonDetails::new).get();
    }
}
