package com.park.spring.security.jpa.securityjwtjpa.component;

import com.park.spring.security.jpa.securityjwtjpa.Repository.PersonRepository;
import com.park.spring.security.jpa.securityjwtjpa.model.Person;
import com.park.spring.security.jpa.securityjwtjpa.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class PersonLoader implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... strings) throws Exception {
        personRepository.deleteAll();

        List<Person> people = Arrays.asList(
                new Person(
                        "User",
                        "1234",
                        new Status(true, true, true, true),
                        Arrays.asList("USER")
                ),
                new Person(
                        "Admin",
                        "1234",
                        new Status(true, true, true, true),
                        Arrays.asList("Admin")
                )
        );
        personRepository.save(people);
    }
}
