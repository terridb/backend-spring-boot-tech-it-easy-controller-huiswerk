package com.techiteasy.TechItEasy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private final JwtRequestFilter jwtRequestFilter;

    public SpringSecurityConfig(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    // De versie uit de opdracht was verouderd volgens intellij
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain filter(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth ->
                                auth
                                        .requestMatchers("/authenticate").permitAll()
                                        .requestMatchers(HttpMethod.POST, "/users").hasRole("ADMIN")
                                        .requestMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")

//                                        Bonusopdracht
                                        .requestMatchers("/users/*/roles/**").hasRole("ADMIN")
                                        .requestMatchers(HttpMethod.GET, "/users/**").hasAnyRole("USER", "ADMIN")

                                        .requestMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
                                        .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
                                        .requestMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN")
                                        .requestMatchers(HttpMethod.GET,
                                                "/televisions/**",
                                                "/ci-modules/**",
                                                "/wall-brackets/**",
                                                "/remote-controllers/**"
                                        ).hasAnyRole("USER", "ADMIN")
                                        .requestMatchers(HttpMethod.POST,
                                                "/televisions",
                                                "/ci-modules",
                                                "/wall-brackets",
                                                "/remote-controllers"
                                        ).hasRole("ADMIN")
                                        .requestMatchers(HttpMethod.PUT,
                                                "/televisions/**",
                                                "/ci-modules/**",
                                                "/wall-brackets/**",
                                                "/remote-controllers/**"
                                        ).hasRole("ADMIN")
                                        .requestMatchers(HttpMethod.DELETE,
                                                "/televisions/**",
                                                "/ci-modules/**",
                                                "/wall-brackets/**",
                                                "/remote-controllers/**"
                                        ).hasRole("ADMIN")
                                        .requestMatchers(HttpMethod.PATCH, "/televisions/**").hasRole("ADMIN")
                                        .requestMatchers("/authenticated").authenticated()
                                        .anyRequest().denyAll()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
