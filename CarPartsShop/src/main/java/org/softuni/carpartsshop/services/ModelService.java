package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.AddPartDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;

public interface ModelService {

    Model addModel(AddPartDto addPartDto, Brand brand);

}
