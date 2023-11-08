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

    private final CurrentUser currentUser;

    public UserProfileController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @GetMapping("/{uuid}/profile")
    public String profile(@PathVariable String uuid) {
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        return "user-profile";
    }


}
