package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginUserController {

    private UserService userService;

    public LoginUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login-error")
    public String onFailure(@ModelAttribute("email") String email,
            Model model) {

        model.addAttribute("email", email);
        model.addAttribute("bad_credentials", "true");

        return "login";
    }

}
