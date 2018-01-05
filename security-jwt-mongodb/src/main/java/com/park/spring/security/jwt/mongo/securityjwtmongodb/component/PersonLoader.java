package com.park.spring.security.jwt.mongo.securityjwtmongodb.component;

import com.park.spring.security.jwt.mongo.securityjwtmongodb.PersonRepository.PersonRepository;
import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Person;
import com.park.spring.security.jwt.mongo.securityjwtmongodb.model.Status;
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
                new Person("A34N7K34A", "User", "1234",
                        new Status(true, true, true, true),
                        Arrays.asList("USER")),
                new Person("J5L3IQR42", "Admin", "1234",
                        new Status(true, true, true, true),
                        Arrays.asList("ADMIN")),
                new Person("P09F34M2K", "Boss", "1234",
                        new Status(true, true, true, true),
                        Arrays.asList("ADMIN", "USER", "BOSS"))
        );
        personRepository.save(people);
    }
}
