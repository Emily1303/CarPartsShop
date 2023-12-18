package org.softuni.carpartsshop.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.softuni.carpartsshop.models.entities.Role;
import org.softuni.carpartsshop.models.enums.RoleNamesEnum;
import org.softuni.carpartsshop.repositories.RoleRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    private RoleServiceImpl serviceToTest;

    @Mock
    private RoleRepository mockRoleRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new RoleServiceImpl(mockRoleRepository);
    }

    @Test
    void findRole() {
        when(mockRoleRepository.findByRoleName(testRole().getRoleName()))
                .thenReturn(Optional.of(testRole()));

        Role receivedRole = serviceToTest.findUserRole(RoleNamesEnum.USER);

        Assertions.assertEquals(testRole().getRoleName(), receivedRole.getRoleName(),
                "The role is not mapped!");
    }

    private static Role testRole() {
        Role role = new Role();
        role.setRoleName(RoleNamesEnum.USER);

        return role;
    }

}