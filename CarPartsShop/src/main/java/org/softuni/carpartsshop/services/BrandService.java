package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.forLogic.AddBrandDto;
import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.dtos.forTemplates.HomeDto;
import org.softuni.carpartsshop.models.entities.Brand;

public interface BrandService {

    Brand addBrand(AddCarDto addCarDto);

    void addNewBrand(AddBrandDto addBrandDto);

    HomeDto getBrandsForHomePage();

}
