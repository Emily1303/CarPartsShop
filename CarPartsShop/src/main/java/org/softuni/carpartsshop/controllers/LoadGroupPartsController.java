package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.services.SubmodelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LoadGroupPartsController {

    private final SubmodelService submodelService;

    public LoadGroupPartsController(SubmodelService submodelService) {
        this.submodelService = submodelService;
    }

    @GetMapping("/{name}/parts/{submodel}")
    public String getPartsIndexPage(@PathVariable("name") String name,
                                    @PathVariable("submodel") String submodel, Model model) {

        Submodel submodelAndParts = submodelService.getSubmodelAndPartsByName(submodel);
        model.addAttribute("submodelParts", submodelAndParts);
        return "parts";
    }

    @GetMapping("/home/{name}/parts/{submodel}")
    public String getPartsHomePage(@PathVariable("name") String name,
                                   @PathVariable("submodel") String submodel, Model model) {

        Submodel submodelAndParts = submodelService.getSubmodelAndPartsByName(submodel);
        model.addAttribute("submodelParts", submodelAndParts);
        return "parts";
    }

}
