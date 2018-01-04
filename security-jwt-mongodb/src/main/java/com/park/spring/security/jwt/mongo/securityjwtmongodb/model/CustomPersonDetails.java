package com.park.spring.security.jwt.mongo.securityjwtmongodb.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomPersonDetails extends Person implements UserDetails {

    public CustomPersonDetails(Person person) {
        super(person);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return super.getRole().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
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
