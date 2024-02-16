package com.Phenix13.Flashcash.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/style.css","/img/**","/login").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((from) -> from
                        .loginPage("/login")
                        .permitAll().usernameParameter("email").defaultSuccessUrl("/",true)
                )
                .logout((logout) -> logout.permitAll());
        return http.build();
    }
}
