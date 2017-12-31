package com.park.spring.security.basic.securitybasic.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("User").password("1234").roles("USER").and()
                .withUser("Admin").password("1234").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/rest/user").hasRole("USER") //allow only roles
                .antMatchers("/rest/admin").hasRole("ADMIN")
                .antMatchers("/rest/home").fullyAuthenticated() //allow any roles
                .antMatchers("/rest/public").permitAll() // allow everyone
                .and().httpBasic();

    }
}
