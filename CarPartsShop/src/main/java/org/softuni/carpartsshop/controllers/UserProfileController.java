package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserProfileController {

    private final UserService userService;

    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home/profile")
    public String profile() {

        return "user-profile";
    }


}
