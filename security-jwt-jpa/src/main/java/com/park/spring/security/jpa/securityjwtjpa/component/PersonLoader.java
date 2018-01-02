package com.park.spring.security.jpa.securityjwtjpa.component;

import com.park.spring.security.jpa.securityjwtjpa.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PersonLoader implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... strings) throws Exception {

    }
}
