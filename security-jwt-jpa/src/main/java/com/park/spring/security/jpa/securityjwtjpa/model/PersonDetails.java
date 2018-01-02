package com.park.spring.security.jpa.securityjwtjpa.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDetails extends Person implements UserDetails {

    private String token; // It never use why ?

    public PersonDetails(String token, Integer id, String username, String password, Status status, List<String> grantedAuthorities) {
        this.token = token;
        super.setId(id);
        super.setUsername(username);
        super.setPassword(password);
        super.setStatus(status);
        super.setRole(grantedAuthorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return super.getRole().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.getStatus().isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.getStatus().isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.getStatus().isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return super.getStatus().isEnabled();
    }
}
