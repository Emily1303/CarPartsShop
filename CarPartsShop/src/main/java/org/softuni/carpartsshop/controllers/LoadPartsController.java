package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.services.SubmodelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LoadPartsController {

    private final SubmodelService submodelService;

    public LoadPartsController(SubmodelService submodelService) {
        this.submodelService = submodelService;
    }

    @GetMapping("/{name}/parts/{submodel}")
    public String getPartsIndexPage(@PathVariable("name") String name,
                                    @PathVariable("submodel") String submodel, Model model) {
        Submodel submodelAndParts = submodelService.getSubmodelAndPartsByName(name);
        model.addAttribute("submodelParts", submodelAndParts);
        return "parts";
    }

    @GetMapping("/{uuid}/home/{name}/parts/{submodel}")
    public String getPartsHomePage(@PathVariable("uuid") String uuid,
                                   @PathVariable("name") String name, @PathVariable("submodel") String submodel) {
        return "parts";
    }

}
