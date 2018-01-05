package com.park.spring.security.jwt.mongo.securityjwtmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Objects;

@Document
public class Person {

    @Id
    private String id;
    @Indexed
    private String username;
    private String password;
    private Status status;
    private Collection<String> role;

    public Person() {
    }

    public Person(Person person) {
        this.id = person.id;
        this.username = person.username;
        this.password = person.password;
        this.status = person.status;
        this.role = person.role;
    }

    public Person(String id, String username, String password, Status status, Collection<String> role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(username, person.username) &&
                Objects.equals(password, person.password) &&
                Objects.equals(status, person.status) &&
                Objects.equals(role, person.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, status, role);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", role=" + role +
                '}';
    }
}