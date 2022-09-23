package SleepTeam.TicTacToe.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    //working on auth using spring security - simon
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf -> csrf.disable())
                .headers(frameOptions-> frameOptions.disable())  //enable h2 console
                .authorizeRequests(auth -> {
                    auth.antMatchers("/users/username/**").authenticated();
                    auth.anyRequest().permitAll();
                })
                .httpBasic(withDefaults())
                .build();

    }
}
