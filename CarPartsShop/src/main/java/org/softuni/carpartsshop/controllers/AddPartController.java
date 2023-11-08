package org.softuni.carpartsshop.controllers;

import jakarta.validation.Valid;
import org.softuni.carpartsshop.models.dtos.AddPartDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Part;
import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.models.enums.FuelsEnum;
import org.softuni.carpartsshop.services.BrandService;
import org.softuni.carpartsshop.services.ModelService;
import org.softuni.carpartsshop.services.PartService;
import org.softuni.carpartsshop.services.SubmodelService;
import org.softuni.carpartsshop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddPartController {

    private final CurrentUser currentUser;

    private final PartService partService;

    private final ModelService modelService;

    private final SubmodelService submodelService;

    private final BrandService brandService;

    public AddPartController(CurrentUser currentUser, PartService partService,
                             ModelService modelService, SubmodelService submodelService, BrandService brandService) {
        this.currentUser = currentUser;
        this.partService = partService;
        this.modelService = modelService;
        this.submodelService = submodelService;
        this.brandService = brandService;
    }

    @GetMapping("/{uuid}/add/parts")
    public String addPart(Model model, @PathVariable String uuid) {
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        if (!model.containsAttribute("addPartDto")) {
            model.addAttribute("addPartDto", AddPartDto.construct());
        }

        return "add-parts";
    }

    @PostMapping("/{uuid}/add/parts")
    public String addPart(@Valid AddPartDto addPartDto, BindingResult bindingResult,
                          RedirectAttributes rAttr, @PathVariable String uuid) {

        if (bindingResult.hasErrors()) {
            rAttr.addFlashAttribute("addPartDto", addPartDto);
            rAttr.addFlashAttribute("org.springframework.validation.BindingResult.addPartDto",
                    bindingResult);

            return "redirect:add/parts";
        }
//
//        Part part = partService.addPart(addPartDto, submodel);
//        submodel.getParts().add(part);

        return "redirect:/home";
    }

}
