package com.calender.security;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder;

@EnableWebMvc
@ComponentScan({ "com.calender.*" })
@Import({ SecurityConfig.class })
@PropertySource({"classpath:application.properties"})
@Configuration
@EnableWebSecurity
public class App_Security {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((requests) -> {
                    requests
                            .requestMatchers("/events").permitAll()
                            .requestMatchers("/events/login").permitAll()
                            .anyRequest().authenticated();
                })
                .formLogin((login) -> {
                    login.loginPage("/events/login").permitAll();
                        }
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/events")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                withDefaultPasswordEncoder()
                        .username("aman")
                        .password("aman")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}