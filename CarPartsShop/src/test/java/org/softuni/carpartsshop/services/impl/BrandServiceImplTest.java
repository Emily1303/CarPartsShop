package org.softuni.carpartsshop.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.models.dtos.forLogic.AddBrandDto;
import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.models.enums.FuelsEnum;
import org.softuni.carpartsshop.repositories.BrandRepository;

import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BrandServiceImplTest {

    private BrandServiceImpl serviceToTest;

    @Mock
    private BrandRepository mockBrandRepository;

    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        serviceToTest = new BrandServiceImpl(mockBrandRepository, modelMapper);
    }

    @Test
    void addBrandIfItExists() {
        Brand brand = testBrand();
        when(mockBrandRepository.findByBrandName(brand.getBrandName()))
                .thenReturn(Optional.of(brand));

        Brand receivedBrand = serviceToTest.addBrand(addCarDto());

        Assertions.assertEquals(testBrand().getBrandName(), receivedBrand.getBrandName(),
                "The brand name is not mapped!");
    }
    @Test
    void addNewBrand() {
        serviceToTest.addNewBrand(addBrandDto());
    }

//    @Test
//    void returnBrandModels() {
//        Brand brand = testBrand();
//        when(mockBrandRepository.findByBrandName(testBrand().getBrandName()))
//                .thenReturn(Optional.of(brand));
//    }

    private static AddCarDto addCarDto() {
        return new AddCarDto("Audi", "A5", "Cabrio",
                "cabrio.png", "1.4 Turbo", "249313", 223,
                "03.2014 - 06.2019", String.valueOf(FuelsEnum.PETROL));
    }

    private static AddBrandDto addBrandDto() {
        return new AddBrandDto("Audi", "audi.png");
    }

    private static Brand testBrand() {
        Brand brand = new Brand();
        brand.setBrandName("Audi");
        brand.setBrandImage("audi.png");

        Model model = new Model();
        brand.setModels(Set.of(model));

        model.setModelName("A5");
        return brand;
    }

}