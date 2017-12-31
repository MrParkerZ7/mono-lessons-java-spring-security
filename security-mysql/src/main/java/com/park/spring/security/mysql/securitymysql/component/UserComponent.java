package com.park.spring.security.mysql.securitymysql.component;

import com.park.spring.security.mysql.securitymysql.model.Status;
import com.park.spring.security.mysql.securitymysql.model.User;
import com.park.spring.security.mysql.securitymysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserComponent implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) {
        this.userRepository.deleteAll();

        List<User> users = Arrays.asList(
                new User("User", "1234", "Park", "USER",
                        new Status(true, true, true, true)),
                new User("Admin", "1234", "Suck", "ADMIN",
                        new Status(true, true, true, true))
        );
        this.userRepository.save(users);
    }
}
