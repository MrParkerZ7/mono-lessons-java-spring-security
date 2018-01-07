package com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.service;

import com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.model.CustomUserDetails;
import com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.model.User;
import com.park.spring.security.oauth.server.mongodb.securityoauthservermongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(username));

        userOptional
                .orElseThrow(() -> new UsernameNotFoundException("Username not found!!"));
        return userOptional
                .map(CustomUserDetails::new)
                .get();
    }
}
