package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;

public interface ModelService {

    Model addModel(AddCarDto addCarDto, Brand brand);

}
