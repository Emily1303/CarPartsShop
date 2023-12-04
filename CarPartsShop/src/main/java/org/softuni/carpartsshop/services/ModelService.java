package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.models.entities.Submodel;

import java.util.List;
import java.util.Set;

public interface ModelService {

    Model addModel(AddCarDto addCarDto, Brand brand);

}
