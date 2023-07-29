package com.szaruga.myapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChainMembers(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET, "/api/members").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/members/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/members").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/members").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/members/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/items").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/items/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/items").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/items").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/items/**").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}