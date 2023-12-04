package org.softuni.carpartsshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShoppingCartController {

    @GetMapping("/{uuid}/shopping-cart")
    public String showShoppingCart(@PathVariable String uuid) {
        return "shopping-cart";
    }

}
