package com.park.spring.security.jpa.securityjwtjpa.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

public class Person {

    class Status {
        private boolean isAccountNonExpired;
        private boolean isAccountNonLocked;
        private boolean isCredentialsNonExpired;
        private boolean isEnabled;

        public Status() {
        }

        public Status(boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled) {
            this.isAccountNonExpired = isAccountNonExpired;
            this.isAccountNonLocked = isAccountNonLocked;
            this.isCredentialsNonExpired = isCredentialsNonExpired;
            this.isEnabled = isEnabled;
        }

        public boolean isAccountNonExpired() {
            return isAccountNonExpired;
        }

        public void setAccountNonExpired(boolean accountNonExpired) {
            isAccountNonExpired = accountNonExpired;
        }

        public boolean isAccountNonLocked() {
            return isAccountNonLocked;
        }

        public void setAccountNonLocked(boolean accountNonLocked) {
            isAccountNonLocked = accountNonLocked;
        }

        public boolean isCredentialsNonExpired() {
            return isCredentialsNonExpired;
        }

        public void setCredentialsNonExpired(boolean credentialsNonExpired) {
            isCredentialsNonExpired = credentialsNonExpired;
        }

        public boolean isEnabled() {
            return isEnabled;
        }

        public void setEnabled(boolean enabled) {
            isEnabled = enabled;
        }
    }

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
