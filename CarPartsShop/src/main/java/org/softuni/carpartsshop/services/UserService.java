package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.LoginDto;
import org.softuni.carpartsshop.models.dtos.RegisterDto;

public interface UserService {

    void registerUser(RegisterDto registerDto);

    boolean loginUser(LoginDto loginDto);

    void logout();

}
