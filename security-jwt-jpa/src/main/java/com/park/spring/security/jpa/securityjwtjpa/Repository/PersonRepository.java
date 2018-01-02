package com.park.spring.security.jpa.securityjwtjpa.Repository;

import com.park.spring.security.jpa.securityjwtjpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);
}
