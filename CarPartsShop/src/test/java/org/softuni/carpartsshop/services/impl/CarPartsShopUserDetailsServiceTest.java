package org.softuni.carpartsshop.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.softuni.carpartsshop.models.entities.Role;
import org.softuni.carpartsshop.models.entities.User;
import org.softuni.carpartsshop.models.enums.RoleNamesEnum;
import org.softuni.carpartsshop.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarPartsShopUserDetailsServiceTest {

    private CarPartsShopUserDetailsService serviceToTest;

    @Mock
    private UserRepository mockUserRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new CarPartsShopUserDetailsService(mockUserRepository);
    }

//    when the user is not found -> throws exception
    @Test
    void testUsernameNotFound() {
        Assertions.assertThrows(UsernameNotFoundException.class,
                () -> serviceToTest.loadUserByUsername("emily@example.com"));
    }

    @Test
    void testUserFound() {
//        Arrange - write what the mocked repository will return
        User user = testUser();
        when(mockUserRepository.findByEmail(user.getEmail()))
                .thenReturn(Optional.of(user));

//        Act - execute the method from the service class
        UserDetails userDetails = serviceToTest.loadUserByUsername(testUser().getEmail());

//        Assert - test if the user from the repository is the same as the user from the userDetails
        Assertions.assertEquals(testUser().getEmail(),
                userDetails.getUsername(), "The username is not mapped to email!");
        Assertions.assertEquals(testUser().getPassword(), userDetails.getPassword(),
                "The password is not mapped to the right password!");
        Assertions.assertEquals(testUser().getRoles().size(), userDetails.getAuthorities().size());
        Assertions.assertTrue(containsAuthority(userDetails, "ROLE_" + RoleNamesEnum.ADMIN),
                "The ADMIN role is not mapped!");
        Assertions.assertTrue(containsAuthority(userDetails, "ROLE_" + RoleNamesEnum.USER),
                "The USER role is not mapped!");
    }

//    create a test user
    private static User testUser() {
        Role roleAdmin = new Role();
        Role roleUser = new Role();
        roleAdmin.setRoleName(RoleNamesEnum.ADMIN);
        roleUser.setRoleName(RoleNamesEnum.USER);

        User user = new User();
        user.setFirstName("Emily");
        user.setLastName("Filipova");
        user.setEmail("emily@example.com");
        user.setPassword("emily13");
        user.setCreatedOn(LocalDateTime.now());
        user.setRoles(List.of(roleAdmin, roleUser));

        return user;
    }

    private boolean containsAuthority(UserDetails userDetails, String expectedAuthority) {
        return userDetails.getAuthorities().stream()
                .anyMatch(a -> expectedAuthority.equals(a.getAuthority()));
    }

}
