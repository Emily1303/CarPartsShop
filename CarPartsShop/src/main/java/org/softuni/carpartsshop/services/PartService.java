package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.forLogic.AddPartDto;
import org.softuni.carpartsshop.models.entities.Part;
import org.softuni.carpartsshop.models.entities.Submodel;

import java.util.List;

public interface PartService {

    Part addPart(AddPartDto addPartDto, Submodel submodel);

    List<Part> getAllPartsByGroupNameAndSubmodel(String group, List<Part> allPartsOfSubmodel);

}
