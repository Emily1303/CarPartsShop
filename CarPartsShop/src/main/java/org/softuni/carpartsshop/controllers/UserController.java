package org.softuni.carpartsshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String register() {
        return "register-user";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
