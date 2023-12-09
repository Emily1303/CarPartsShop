package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.models.entities.User;
import org.softuni.carpartsshop.services.UserService;
import org.softuni.carpartsshop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
public class UserProfileController {

    private final UserService userService;

    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profile() {

        return "user-profile";
    }


}
