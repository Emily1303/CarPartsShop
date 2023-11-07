package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.AddPartDto;
import org.softuni.carpartsshop.models.entities.Part;
import org.softuni.carpartsshop.models.entities.Submodel;

public interface PartService {

    Part addPart(AddPartDto addPartDto, Submodel submodel);

}
