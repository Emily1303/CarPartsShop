package org.softuni.carpartsshop.controllers;

import jakarta.validation.Valid;
import org.softuni.carpartsshop.models.dtos.forLogic.AddBrandDto;
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
public class AddBrandController {

    private BrandService brandService;

    public AddBrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brand")
    public String addBrand(Model model) {
        if (!model.containsAttribute("addBrandDto")) {
            model.addAttribute("addBrandDto", AddBrandDto.construct());
        }

        return "add-brand";
    }

    @PostMapping("/brand")
    public String addBrand(@Valid AddBrandDto addBrandDto, BindingResult bindingResult,
                           RedirectAttributes rAttr) {

        if (bindingResult.hasErrors()) {
            rAttr.addFlashAttribute("addBrandDto", addBrandDto);
            rAttr.addFlashAttribute("org.springframework.validation.BindingResult.addBrandDto",
                    bindingResult);

            return "redirect:/brand";
        }

        brandService.addNewBrand(addBrandDto);

        return "redirect:/add/car";
    }

}
