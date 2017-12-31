package com.park.spring.security.mysql.securitymysql.repository;

import com.park.spring.security.mysql.securitymysql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserId(String userId);
}
