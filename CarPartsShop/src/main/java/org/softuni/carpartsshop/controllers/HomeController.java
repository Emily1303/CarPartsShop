package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/{uuid}/home")
    public String homePage(@PathVariable("uuid") String uuid) {
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        return "home";
    }

}
