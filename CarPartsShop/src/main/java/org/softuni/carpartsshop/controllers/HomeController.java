package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.models.dtos.forTemplates.HomeDto;
import org.softuni.carpartsshop.services.BrandService;
import org.softuni.carpartsshop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private final CurrentUser currentUser;

    private final BrandService brandService;

    public HomeController(CurrentUser currentUser, BrandService brandService) {
        this.currentUser = currentUser;
        this.brandService = brandService;
    }

    @GetMapping("/")
    public String indexPage(Model model) {
        HomeDto homeDto = brandService.getBrandsForHomePage();
        model.addAttribute("homeDto", homeDto);

        return "index";
    }

    @GetMapping("/{uuid}/home")
    public String homePage(@PathVariable("uuid") String uuid, Model model) {
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        HomeDto homeDto = brandService.getBrandsForHomePage();
        model.addAttribute("homeDto", homeDto);

        return "home";
    }

}
