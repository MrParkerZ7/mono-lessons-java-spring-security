package com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.component;

import com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.model.Status;
import com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.model.User;
import com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.repository.UserRepository;
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
                new User("A86DFW", "User", "1234", "Park", "Suck",
                        new Status(true, true, true, true),
                        Arrays.asList("USER")),
                new User("WM3O4N", "Admin", "1234", "Rose", "Marry",
                        new Status(true, true, true, true),
                        Arrays.asList("ADMIN")),
                new User("S3LQ89", "Boss", "1234", "Press", "Craw",
                        new Status(true, true, true, true),
                        Arrays.asList("ADMIN", "USER"))
        );

        userRepository.save(users);
    }
}
