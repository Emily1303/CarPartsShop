package org.softuni.carpartsshop.services;

import org.softuni.carpartsshop.models.dtos.AddCarDto;
import org.softuni.carpartsshop.models.dtos.AddPartDto;
import org.softuni.carpartsshop.models.dtos.HomeDto;
import org.softuni.carpartsshop.models.entities.Brand;

public interface BrandService {

    Brand addBrand(AddCarDto addCarDto);

    HomeDto getBrandsForHomePage();

}
