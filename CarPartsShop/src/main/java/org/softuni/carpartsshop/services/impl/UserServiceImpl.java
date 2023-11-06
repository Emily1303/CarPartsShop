package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.models.dtos.LoginDto;
import org.softuni.carpartsshop.models.dtos.RegisterDto;
import org.softuni.carpartsshop.models.entities.User;
import org.softuni.carpartsshop.repositories.UserRepository;
import org.softuni.carpartsshop.services.UserService;
import org.softuni.carpartsshop.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(RegisterDto registerDto) {
        User newUser = new User();

        newUser.setFirstName(registerDto.firstName());
        newUser.setLastName(registerDto.lastName());
        newUser.setEmail(registerDto.email());
        newUser.setPassword(passwordEncoder.encode(registerDto.password()));
        newUser.setCreatedOn(LocalDateTime.now());
        newUser.setUuid(UUID.randomUUID());

        userRepository.save(newUser);
    }

    @Override
    public boolean loginUser(LoginDto loginDto) {
        Optional<User> byEmail = userRepository.findByEmail(loginDto.email());

        boolean loginSuccessful = false;

        if (byEmail.isEmpty()) {
            return false;
        }

        User user = byEmail.get();

        String rawPassword = loginDto.password();
        String encodedPassword = user.getPassword();

        if (passwordEncoder.matches(rawPassword, encodedPassword)) {
            currentUser.setLogged(true);
            currentUser.setFirstName(user.getFirstName());
            currentUser.setLastName(user.getLastName());
            currentUser.setUuid(user.getUuid());

            loginSuccessful = true;
        }

        return loginSuccessful;
    }

    @Override
    public void logout() {
        currentUser.logout();
    }

    @Override
    public UUID getUuid(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.email()).get();

        return user.getUuid();
    }

}
