package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.models.dtos.forTemplates.AllPartDtos;
import org.softuni.carpartsshop.models.dtos.forTemplates.PartDto;
import org.softuni.carpartsshop.models.entities.Part;
import org.softuni.carpartsshop.services.PartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ShoppingCartController {

    private final PartService partService;

    public ShoppingCartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/home/shopping-cart")
    public String showShoppingCart(Model model) {

        return "shopping-cart";
    }

    @PostMapping("/home/add/{id}")
    public String addToShoppingCart(@PathVariable("id") Long id) {

        Part part = partService.addPartInShoppingCart(id);
        AllPartDtos allPartDtos = partService.showInShoppingCart(part);
        return "redirect:/home/shopping-cart";
    }

}
