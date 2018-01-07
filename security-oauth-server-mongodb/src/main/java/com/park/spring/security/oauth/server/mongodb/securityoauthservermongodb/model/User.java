package com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
public class User {

    @Id
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Status status;
    private Collection<String> role;

    public User() {
    }

    public User(String id, String username, String password, String firstName, String lastName, Status status, Collection<String> role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.role = role;
    }

    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.status = user.status;
        this.role = user.role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Collection<String> getRole() {
        return role;
    }

    public void setRole(Collection<String> role) {
        this.role = role;
    }
}
