package com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class CustomUserDetails extends User implements UserDetails {

    public CustomUserDetails(User user) {
        super(user);
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
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return super.getRole().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
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
