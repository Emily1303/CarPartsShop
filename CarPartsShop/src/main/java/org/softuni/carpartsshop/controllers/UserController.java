package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.models.dtos.RegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String register(Model model) {

        if (!model.containsAttribute("registerDto")) {
            model.addAttribute("registerDto", RegisterDto.construct());
        }

        return "register-user";
    }

    @PostMapping("/register")
    public String register(RegisterDto registerDto) {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
