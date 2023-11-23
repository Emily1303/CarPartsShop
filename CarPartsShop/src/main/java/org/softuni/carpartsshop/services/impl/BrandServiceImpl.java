package org.softuni.carpartsshop.services.impl;

import org.softuni.carpartsshop.models.dtos.AddCarDto;
import org.softuni.carpartsshop.models.dtos.AddPartDto;
import org.softuni.carpartsshop.models.dtos.BrandDto;
import org.softuni.carpartsshop.models.dtos.HomeDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.repositories.BrandRepository;
import org.softuni.carpartsshop.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand addBrand(AddCarDto addCarDto) {
        Optional<Brand> byBrandName = brandRepository.findByBrandName(addCarDto.brandName());

        if (byBrandName.isPresent()) {
            return byBrandName.get();
        }

        Brand newbBrand = new Brand();
        newbBrand.setBrandName(addCarDto.brandName());
        newbBrand.setBrandImage(addCarDto.brandImage());
        newbBrand.setUuid(UUID.randomUUID());

        brandRepository.save(newbBrand);

        return newbBrand;
    }

    public HomeDto getBrandsForHomePage() {
        List<Brand> allBrands = brandRepository.getAllBrands();
        List<BrandDto> brandDtoList = new ArrayList<>();

        for (int i = 0; i < allBrands.size(); i++) {
            BrandDto brandDto = new BrandDto(allBrands.get(i));
            brandDtoList.add(brandDto);
        }

        return new HomeDto(brandDtoList);
    }
}
