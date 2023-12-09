package org.softuni.carpartsshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShoppingCartController {

    @GetMapping("/shopping-cart")
    public String showShoppingCart() {
        return "shopping-cart";
    }

}
