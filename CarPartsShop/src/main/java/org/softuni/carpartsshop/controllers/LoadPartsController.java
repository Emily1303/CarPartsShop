package org.softuni.carpartsshop.controllers;

import org.softuni.carpartsshop.models.entities.Part;
import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.services.PartService;
import org.softuni.carpartsshop.services.SubmodelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class LoadPartsController {

    private final SubmodelService submodelService;

    private final PartService partService;

    public LoadPartsController(SubmodelService submodelService, PartService partService) {
        this.submodelService = submodelService;
        this.partService = partService;
    }

    @GetMapping("/{name}/parts/{submodel}/{group}")
    public String getAllPartsIndexPage(@PathVariable("name") String name,
                                       @PathVariable("submodel") String submodel,
                                       @PathVariable("group") String group, Model model) {

        Submodel submodelAndParts = submodelService.getSubmodelAndPartsByName(submodel);
        List<Part> parts = submodelAndParts.getParts();
        List<Part> allPartsOfGivenGroup = partService.getAllPartsByGroupNameAndSubmodel(group, parts);

        model.addAttribute("submodelAndParts", submodelAndParts);
        model.addAttribute("allPartsOfGivenGroup", allPartsOfGivenGroup);

        return "show-parts";
    }

    @GetMapping("/{uuid}/home/{name}/parts/{submodel}/{group}")
    public String getAllPartsHomePage(@PathVariable("uuid") String uuid,
                                      @PathVariable("name") String name,
                                      @PathVariable("submodel") String submodel,
                                      @PathVariable("group") String group, Model model) {

        Submodel submodelAndParts = submodelService.getSubmodelAndPartsByName(submodel);
        List<Part> parts = submodelAndParts.getParts();
        List<Part> allPartsOfGivenGroup = partService.getAllPartsByGroupNameAndSubmodel(group, parts);

        model.addAttribute("submodelAndParts", submodelAndParts);
        model.addAttribute("allPartsOfGivenGroup", allPartsOfGivenGroup);

        return "show-parts";
    }

}
