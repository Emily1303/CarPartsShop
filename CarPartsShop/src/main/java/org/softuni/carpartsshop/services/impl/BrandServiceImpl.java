package org.softuni.carpartsshop.services.impl;

import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.models.dtos.forLogic.AddBrandDto;
import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.dtos.forTemplates.BrandDto;
import org.softuni.carpartsshop.models.dtos.forTemplates.HomeDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.repositories.BrandRepository;
import org.softuni.carpartsshop.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Brand addBrand(AddCarDto addCarDto) {
        return brandRepository.findByBrandName(addCarDto.brandName()).get();
    }

    @Override
    public void addNewBrand(AddBrandDto addBrandDto) {
        Brand brand = new Brand();
        brand.setBrandName(addBrandDto.nameBrand());
        brand.setBrandImage(addBrandDto.brandImage());
        brand.setUuid(UUID.randomUUID());
        brand.setModels(new HashSet<>());

        brandRepository.save(brand);
    }

    public HomeDto getBrandsForHomePage() {
        List<Brand> allBrands = brandRepository.getAllBrands();
        Set<BrandDto> brandDtoList = new HashSet<>();

        for (int i = 0; i < allBrands.size(); i++) {
            BrandDto brandDto = modelMapper.map(allBrands.get(i), BrandDto.class);
            brandDtoList.add(brandDto);
        }

        return new HomeDto(brandDtoList.stream()
                .sorted(Comparator.comparing(BrandDto::getBrandName))
                .collect(Collectors.toCollection(LinkedHashSet::new)));
    }

    public Set<Model> getAllModelsByBrandName(String name) {
        return brandRepository.findByBrandName(name).get().getModels();
    }

}
