package com.park.spring.security.mysql.securitymysql.model;

import javafx.beans.property.SimpleSetProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class CustomUserDetails extends User implements UserDetails {
    public CustomUserDetails(User user) {
        super(user);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_" + getRole()));
    }

    @Override
    public String getPassword() {
        return super.getUserPassword();
    }

    @Override
    public String getUsername() {
        return super.getUserId();
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
