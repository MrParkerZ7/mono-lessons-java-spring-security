package com.park.spring.security.jwt.mongo.securityjwtmongodb.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomPersonDetails extends Person implements UserDetails {

    private Person personClient;

    public CustomPersonDetails(Person person) {
        super(person);
    }

    public CustomPersonDetails(Person personClient, Person personDB) {
        super(personDB);
        this.personClient = personClient;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return super.getRole().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        if (personClient.getUsername().equals(super.getUsername()))
            return super.getPassword();
        else
            return null;
    }

    @Override
    public String getUsername() {
        if (personClient.getPassword().equals(super.getPassword()))
            return super.getUsername();
        else
            return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.getStatus().getAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.getStatus().getAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.getStatus().getCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return super.getStatus().getEnable();
    }
}
