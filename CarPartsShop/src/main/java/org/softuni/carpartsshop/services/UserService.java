package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.forLogic.LoginDto;
import org.softuni.carpartsshop.models.dtos.forLogic.RegisterDto;

import java.util.UUID;

public interface UserService {

    void registerUser(RegisterDto registerDto);

    boolean loginUser(LoginDto loginDto);

    void logout();

    UUID getUuid(LoginDto loginDto);

}
