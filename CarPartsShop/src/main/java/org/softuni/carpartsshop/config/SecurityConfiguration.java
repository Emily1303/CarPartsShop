package org.softuni.carpartsshop.config;

import org.softuni.carpartsshop.repositories.UserRepository;
import org.softuni.carpartsshop.services.impl.CarPartsShopUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
//                static resources can be seen by anyone
                authorizeRequests -> authorizeRequests
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
//                  pages that can be seen by all users
                        .requestMatchers("/", "/{name}", "/{name}/parts/{submodel}",
                                "/{name}/parts/{submodel}/{group}", "/login",
                                "/register", "/login-error").permitAll()
//                  all other requests are authenticated
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin -> (
//                        this is the login page and if someone tries to access something
//                        that is not allowed - redirect to login page
                        formLogin.loginPage("/login")
                        ).usernameParameter("email")
                        .passwordParameter("password")
//                        if the user logged in successfully
                        .defaultSuccessUrl("/home")
//                        if the user log in is not successful
                        .failureForwardUrl("/login-error")
        ).logout(
//                the logout - redirect to index page
                logout -> logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/")
//                        delete HTTP session
                        .invalidateHttpSession(true)
        );

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new CarPartsShopUserDetailsService(userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

}
