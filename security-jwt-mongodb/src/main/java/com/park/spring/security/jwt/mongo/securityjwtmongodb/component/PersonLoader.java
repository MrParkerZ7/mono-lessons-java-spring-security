package com.park.spring.security.jwt.mongo.securityjwtmongodb.component;

import com.park.spring.security.jwt.mongo.securityjwtmongodb.PersonRepository.PersonRepository;
import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Person;
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
                new Person(null, "User", "1234",
                        new Person().new Status(true, true, true, true),
                        Arrays.asList("USER")),
                new Person(null, "Admin", "1234",
                        new Person().new Status(true, true, true, true),
                        Arrays.asList("ADMIN")),
                new Person(null, "Boss", "1234",
                        new Person().new Status(true, true, true, true),
                        Arrays.asList("ADMIN", "USER", "BOSS"))
        );

        personRepository.save(people);
    }
}
