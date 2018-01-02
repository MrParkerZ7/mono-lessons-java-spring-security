package com.park.spring.security.jpa.securityjwtjpa.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private Status status;
    private Collection<String> role;

    public Person() {
    }

    public Person(String username, String password, Status status, Collection<String> role) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    public Person(Person person) {
        this.id = person.id;
        this.username = person.username;
        this.password = person.password;
        this.status = person.status;
        this.role = person.role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
