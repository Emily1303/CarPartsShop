package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.models.entities.Role;
import org.softuni.carpartsshop.models.entities.User;
import org.softuni.carpartsshop.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class CarPartsShopUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public CarPartsShopUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    find the user with this email
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).map(this :: map)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " is not found!"));
    }

//    if there is a user with this email in the database - map the info to the current user
    private UserDetails map(User user) {
        return org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRoles().stream().map(CarPartsShopUserDetailsService ::mapRoles)
                        .collect(Collectors.toList()))
                .build();
    }

    private static GrantedAuthority mapRoles(Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role.getRoleName().name());
    }

}
