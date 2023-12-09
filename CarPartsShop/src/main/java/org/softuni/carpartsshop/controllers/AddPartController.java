package org.softuni.carpartsshop.controllers;

import jakarta.validation.Valid;
import org.softuni.carpartsshop.models.dtos.forLogic.AddPartDto;
import org.softuni.carpartsshop.models.dtos.forTemplates.HomeDto;
import org.softuni.carpartsshop.models.entities.Part;
import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.services.BrandService;
import org.softuni.carpartsshop.services.ModelService;
import org.softuni.carpartsshop.services.PartService;
import org.softuni.carpartsshop.services.SubmodelService;
import org.softuni.carpartsshop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddPartController {

    private final PartService partService;

    private final SubmodelService submodelService;

    public AddPartController(PartService partService, SubmodelService submodelService) {
        this.partService = partService;
        this.submodelService = submodelService;
    }

    @GetMapping("/add/parts")
    public String addPart(Model model) {
        if (!model.containsAttribute("addPartDto")) {
            model.addAttribute("addPartDto", AddPartDto.construct());
        }

        HomeDto homeDto = submodelService.getSubmodelsForHomePage();
        model.addAttribute("homeDto", homeDto);

        return "add-parts";
    }

    @PostMapping("/add/parts")
    public String addPart(@Valid AddPartDto addPartDto, BindingResult bindingResult,
                          RedirectAttributes rAttr) {

        if (bindingResult.hasErrors()) {
            rAttr.addFlashAttribute("addPartDto", addPartDto);
            rAttr.addFlashAttribute("org.springframework.validation.BindingResult.addPartDto",
                    bindingResult);

            return "redirect:/add/parts";
        }

        Submodel submodel = submodelService.getSubmodel(addPartDto);
        Part part = partService.addPart(addPartDto, submodel);
        submodel.getParts().add(part);

        return "redirect:/home";
    }

}
