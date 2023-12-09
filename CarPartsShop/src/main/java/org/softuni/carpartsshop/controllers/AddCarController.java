package org.softuni.carpartsshop.controllers;

import jakarta.validation.Valid;
import org.softuni.carpartsshop.models.dtos.forLogic.AddBrandDto;
import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.dtos.forTemplates.HomeDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.models.enums.FuelsEnum;
import org.softuni.carpartsshop.services.BrandService;
import org.softuni.carpartsshop.services.ModelService;
import org.softuni.carpartsshop.services.SubmodelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddCarController {

    private BrandService brandService;

    private ModelService modelService;

    private SubmodelService submodelService;

    public AddCarController(BrandService brandService, ModelService modelService, SubmodelService submodelService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.submodelService = submodelService;
    }

    @GetMapping("/add/car")
    public String addCar(Model model) {
        if (!model.containsAttribute("addCarDto")) {
            model.addAttribute("addCarDto", AddCarDto.construct());
        }

        model.addAttribute("addBrandDto", AddBrandDto.construct());
        HomeDto homeDto = brandService.getBrandsForHomePage();
        model.addAttribute("homeDto", homeDto);

        return "add-car";
    }

    @ModelAttribute
    public FuelsEnum[] fuels() {
        return FuelsEnum.values();
    }

    @PostMapping("/add/car")
    public String addCar(@Valid AddCarDto addCarDto, BindingResult bindingResult,
                         RedirectAttributes rAttr) {

        if (bindingResult.hasErrors()) {
            rAttr.addFlashAttribute("addCarDto", addCarDto);
            rAttr.addFlashAttribute("org.springframework.validation.BindingResult.addCarDto",
                    bindingResult);

            return "redirect:/add/car";
        }

        Brand brand = brandService.addBrand(addCarDto);
        org.softuni.carpartsshop.models.entities.Model modelForBrand = modelService.addModel(addCarDto, brand);

        if (!brand.getModels().contains(modelForBrand)) {
            brand.getModels().add(modelForBrand);
        }

        Submodel submodel = submodelService.addSubmodel(addCarDto, modelForBrand);

        if (!modelForBrand.getSubmodels().contains(submodel)) {
            modelForBrand.getSubmodels().add(submodel);
        }

        return "redirect:/add/parts";
    }
}
