package org.softuni.carpartsshop.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.softuni.carpartsshop.models.dtos.forLogic.RegisterDto;
import org.softuni.carpartsshop.repositories.RoleRepository;
import org.softuni.carpartsshop.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserServiceImpl serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    private PasswordEncoder passwordEncoder;

    private RoleServiceImpl roleService;

    @Mock
    private RoleRepository mockRoleRepository;

    @BeforeEach
    void setUp() {
        roleService = new RoleServiceImpl(mockRoleRepository);
        serviceToTest = new UserServiceImpl(mockUserRepository, passwordEncoder, roleService);
    }

//    @Test
//    void addNewUser() {
//        serviceToTest.registerUser(registerDto());
//    }

    public static RegisterDto registerDto() {
        return new RegisterDto("Emily", "Filipova", "emily@example.com",
                "Emi123*f", "Emi123*f");
    }

}