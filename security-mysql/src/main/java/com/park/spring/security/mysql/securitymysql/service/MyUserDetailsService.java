package com.park.spring.security.mysql.securitymysql.service;

import com.park.spring.security.mysql.securitymysql.model.CustomUserDetails;
import com.park.spring.security.mysql.securitymysql.model.User;
import com.park.spring.security.mysql.securitymysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUserId(userId);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("UserId no found!!"));

        return optionalUser
                .map(CustomUserDetails::new).get();
    }
}
