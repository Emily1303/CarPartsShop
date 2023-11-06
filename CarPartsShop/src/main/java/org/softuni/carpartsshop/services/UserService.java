package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.LoginDto;
import org.softuni.carpartsshop.models.dtos.RegisterDto;
import org.softuni.carpartsshop.models.entities.User;

import java.util.UUID;

public interface UserService {

    void registerUser(RegisterDto registerDto);

    boolean loginUser(LoginDto loginDto);

    void logout();

    UUID getUuid(LoginDto loginDto);

}
