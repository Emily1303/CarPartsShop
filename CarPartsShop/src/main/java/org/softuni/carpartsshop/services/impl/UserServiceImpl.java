package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.models.dtos.forLogic.RegisterDto;
import org.softuni.carpartsshop.models.entities.Role;
import org.softuni.carpartsshop.models.entities.User;
import org.softuni.carpartsshop.models.enums.RoleNamesEnum;
import org.softuni.carpartsshop.repositories.UserRepository;
import org.softuni.carpartsshop.services.RoleService;
import org.softuni.carpartsshop.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public void registerUser(RegisterDto registerDto) {
        User newUser = new User();

        newUser.setFirstName(registerDto.firstName());
        newUser.setLastName(registerDto.lastName());
        newUser.setEmail(registerDto.email());
        newUser.setPassword(passwordEncoder.encode(registerDto.password()));
        newUser.setCreatedOn(LocalDateTime.now());
        newUser.getRoles().add(roleService.findUserRole(RoleNamesEnum.USER));

        userRepository.save(newUser);
    }

}
