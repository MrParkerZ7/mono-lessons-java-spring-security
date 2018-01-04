package com.park.spring.security.jwt.mongo.securityjwtmongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document
public class Person {

    public class Status {
        private Boolean isAccountNonExpired;
        private Boolean isAccountNonLocked;
        private Boolean isCredentialsNonExpired;
        private Boolean isEnable;

        public Status() {
        }

        public Status(Boolean isAccountNonExpired, Boolean isAccountNonLocked, Boolean isCredentialsNonExpired, Boolean isEnable) {
            this.isAccountNonExpired = isAccountNonExpired;
            this.isAccountNonLocked = isAccountNonLocked;
            this.isCredentialsNonExpired = isCredentialsNonExpired;
            this.isEnable = isEnable;
        }

        public Boolean getAccountNonExpired() {
            return isAccountNonExpired;
        }

        public void setAccountNonExpired(Boolean accountNonExpired) {
            isAccountNonExpired = accountNonExpired;
        }

        public Boolean getAccountNonLocked() {
            return isAccountNonLocked;
        }

        public void setAccountNonLocked(Boolean accountNonLocked) {
            isAccountNonLocked = accountNonLocked;
        }

        public Boolean getCredentialsNonExpired() {
            return isCredentialsNonExpired;
        }

        public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
            isCredentialsNonExpired = credentialsNonExpired;
        }

        public Boolean getEnable() {
            return isEnable;
        }

        public void setEnable(Boolean enable) {
            isEnable = enable;
        }
    }

    @Id
    private String id;
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
}