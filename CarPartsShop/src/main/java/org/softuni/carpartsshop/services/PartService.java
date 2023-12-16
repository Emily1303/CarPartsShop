package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.forLogic.AddPartDto;
import org.softuni.carpartsshop.models.dtos.forTemplates.AllPartDtos;
import org.softuni.carpartsshop.models.dtos.forTemplates.PartDto;
import org.softuni.carpartsshop.models.entities.Part;
import org.softuni.carpartsshop.models.entities.Submodel;

import java.util.List;
import java.util.Optional;

public interface PartService {

    Part addPart(AddPartDto addPartDto, Submodel submodel);

    List<Part> getAllPartsByGroupNameAndSubmodel(String group, List<Part> allPartsOfSubmodel);

    Part addPartInShoppingCart(Long id);

    AllPartDtos showInShoppingCart(Part part);

}
