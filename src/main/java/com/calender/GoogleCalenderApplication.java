package com.calender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.client.RestClient;

@SpringBootApplication

public class GoogleCalenderApplication {

    public static void main(String... args) {
        SpringApplication.run(GoogleCalenderApplication.class, args);
    }

}