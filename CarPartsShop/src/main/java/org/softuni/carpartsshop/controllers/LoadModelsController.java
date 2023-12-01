package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.services.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

@Controller
public class LoadModelsController {

    private final BrandService brandService;

    public LoadModelsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/{name}")
    public String getModelsIndexPage(@PathVariable("name") String name, Model model) {
        Set<org.softuni.carpartsshop.models.entities.Model> allModels =
                brandService.getAllModelsByBrandName(name);
        model.addAttribute("allModels", allModels);
        return "index-model";
    }

    @GetMapping("/{uuid}/home/{name}")
    public String getModelsHomePage(@PathVariable("uuid") String uuid, @PathVariable("name") String name, Model model) {
        Set<org.softuni.carpartsshop.models.entities.Model> allModels = brandService.getAllModelsByBrandName(name);
        model.addAttribute("allModels", allModels);
        return "index-model";
    }

}
