package org.softuni.carpartsshop.controllers;

import jakarta.validation.Valid;
import org.softuni.carpartsshop.models.dtos.forLogic.AddBrandDto;
import org.softuni.carpartsshop.models.dtos.forTemplates.HomeDto;
import org.softuni.carpartsshop.services.BrandService;
import org.softuni.carpartsshop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
