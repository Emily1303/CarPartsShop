package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.models.entities.Submodel;

public interface SubmodelService {

    Submodel addSubmodel(AddCarDto addCarDto, Model model);

}
