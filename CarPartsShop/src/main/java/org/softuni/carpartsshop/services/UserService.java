package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.forLogic.LoginDto;
import org.softuni.carpartsshop.models.dtos.forLogic.RegisterDto;
import org.softuni.carpartsshop.models.entities.User;

import java.util.UUID;

public interface UserService {

    void registerUser(RegisterDto registerDto);

}
