package org.softuni.carpartsshop.services.impl;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.models.enums.FuelsEnum;
import org.softuni.carpartsshop.repositories.ModelRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ModelServiceImplTest {

    private ModelServiceImpl serviceToTest;

    @Mock
    private ModelRepository mockModelRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new ModelServiceImpl(mockModelRepository);
    }

    @Test
    void addModelIfNotExist() {
        Brand brand = new Brand();
        brand.setBrandName("Audi");
        brand.setBrandImage("audi.png");

        serviceToTest.addModel(addCarDto(), brand);
    }

    @Test
    void returnModel() {
        Brand brand = new Brand();
        brand.setBrandName("Audi");
        brand.setBrandImage("audi.png");

        Model model = model();
        when(mockModelRepository.findByModelName(model.getModelName()))
                .thenReturn(Optional.of(model));

        Model receivedModel = serviceToTest.addModel(addCarDto(), brand);

        Assertions.assertEquals(model().getModelName(), receivedModel.getModelName(),
                "The model name is not mapped!");
    }

    private static AddCarDto addCarDto() {
        return new AddCarDto("Audi", "A5", "Cabrio",
                "cabrio.png", "1.4 Turbo", "249313", 223,
                "03.2014 - 06.2019", String.valueOf(FuelsEnum.PETROL));
    }

    private static Model model() {
        Model model = new Model();
        model.setModelName("A5");

        return model;
    }

}