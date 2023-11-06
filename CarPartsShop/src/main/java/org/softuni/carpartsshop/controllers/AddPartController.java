package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.models.dtos.AddPartDto;
import org.softuni.carpartsshop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parts/add")
public class AddPartController {

    private final CurrentUser currentUser;

    public AddPartController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping
    public String addPart(Model model) {
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        if (!model.containsAttribute("addPartDto")) {
            model.addAttribute("addPartDto", AddPartDto.construct());
        }

        return "add-parts";
    }

    @PostMapping()
    public String addPart(AddPartDto addPartDto) {

        return "redirect:/home";
    }

}
