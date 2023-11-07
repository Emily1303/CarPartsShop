package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.AddPartDto;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.models.entities.Submodel;

public interface SubmodelService {

    Submodel addSubmodel(AddPartDto addPartDto, Model model);

}
