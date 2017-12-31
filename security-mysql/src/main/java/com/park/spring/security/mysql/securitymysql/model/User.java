package com.park.spring.security.mysql.securitymysql.model;

import javax.persistence.*;

@Entity
@Table(name = "USER_DETAIL")
public class User {

    @Id
    @Column(unique = true, nullable = false) // Make column unique
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id", unique = true, nullable = false)
    private String userId;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    private String name;

    private String role;

    private Status status;

    public User() {
    }

    public User(String userId, String userPassword, String name, String role, Status status) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.name = name;
        this.role = role;
        this.status = status;
    }

    public User(User user) {
        this.id = user.id;
        this.userId = user.userId;
        this.userPassword = user.userPassword;
        this.name = user.name;
        this.role = user.role;
        this.status = user.status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
