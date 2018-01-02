package com.park.spring.security.mongodb.securitymongodb.component;

import com.park.spring.security.mongodb.securitymongodb.model.Status;
import com.park.spring.security.mongodb.securitymongodb.model.User;
import com.park.spring.security.mongodb.securitymongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {
        userRepository.deleteAll();

        List<User> users = Arrays.asList(
                new User("User", "1234", "Park",
                        new Status(true, true, true, true),
                        Arrays.asList("USER")),
                new User("Admin", "1234", "Frank",
                        new Status(true, true, true, true),
                        Arrays.asList("ADMIN")),
                new User("Boss", "1234", "Mar",
                        new Status(true, true, true, true),
                        Arrays.asList("ADMIN", "USER"))
        );

        userRepository.save(users);
    }
}
