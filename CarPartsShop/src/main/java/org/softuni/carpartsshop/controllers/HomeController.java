package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.models.dtos.forTemplates.HomeDto;
import org.softuni.carpartsshop.services.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    private final BrandService brandService;

    public HomeController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/")
    public String indexPage(Model model) {
        HomeDto homeDto = brandService.getBrandsForHomePage();
        model.addAttribute("homeDto", homeDto);

        return "index";
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        HomeDto homeDto = brandService.getBrandsForHomePage();
        model.addAttribute("homeDto", homeDto);

        return "home";
    }

}
