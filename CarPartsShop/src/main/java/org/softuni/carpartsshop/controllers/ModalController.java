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
public class ModalController {

    private CurrentUser currentUser;

    private BrandService brandService;

    public ModalController(CurrentUser currentUser, BrandService brandService) {
        this.currentUser = currentUser;
        this.brandService = brandService;
    }

    @GetMapping("/{uuid}/brand")
    public String addBrand(Model model, @PathVariable String uuid) {
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        if (!model.containsAttribute("addBrandDto")) {
            model.addAttribute("addBrandDto", AddBrandDto.construct());
        }

        return "modal-brand";
    }

    @PostMapping("/{uuid}/brand")
    public String addBrand(@Valid AddBrandDto addBrandDto, BindingResult bindingResult,
                           RedirectAttributes rAttr, @PathVariable String uuid) {

        if (bindingResult.hasErrors()) {
            rAttr.addFlashAttribute("addBrandDto", addBrandDto);
            rAttr.addFlashAttribute("org.springframework.validation.BindingResult.addBrandDto",
                    bindingResult);

            return "redirect:/" + uuid + "/add-brand";
        }

        brandService.addNewBrand(addBrandDto);

        return "redirect:/" + uuid + "/add/car";
    }

}
