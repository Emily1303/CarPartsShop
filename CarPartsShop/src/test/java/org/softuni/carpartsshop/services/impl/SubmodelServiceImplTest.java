package org.softuni.carpartsshop.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.dtos.forLogic.AddPartDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.models.entities.Part;
import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.models.enums.FuelsEnum;
import org.softuni.carpartsshop.repositories.SubmodelRepository;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SubmodelServiceImplTest {

    private SubmodelServiceImpl serviceToTest;

    @Mock
    private SubmodelRepository mockSubmodelRepository;

    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        serviceToTest = new SubmodelServiceImpl(mockSubmodelRepository, modelMapper);
    }

    @Test
    void addSubmodelIfItExists() {
        Submodel submodel = testSubmodel();
        when(mockSubmodelRepository.findBySubmodelName(submodel.getSubmodelName()))
                .thenReturn(Optional.of(submodel));

        serviceToTest.addSubmodel(addCarDto(), model());

        Assertions.assertEquals(testSubmodel().getSubmodelName(), addCarDto().submodelName(),
                "The submodel name is not mapped!");
        Assertions.assertEquals(testSubmodel().getSubmodelImage(), addCarDto().submodelImage(),
                "The submodel image is not mapped!");
        Assertions.assertEquals(testSubmodel().getEngine(), addCarDto().engine(),
                "The engine is not mapped!");
        Assertions.assertEquals(testSubmodel().getEngineCode(), addCarDto().engineCode(),
                "The engine code is not mapped!");
        Assertions.assertEquals(testSubmodel().getHorsePower(), addCarDto().horsePower(),
                "The horse power is not mapped!");
        Assertions.assertEquals(testSubmodel().getFuel().toString(), addCarDto().fuel(),
                "The fuel is not mapped!");
    }

    @Test
    void addSubmodelIfItDoesNotExist() {
        serviceToTest.addSubmodel(addCarDto(), model());
    }

    @Test
    void getSubmodel() {
        Submodel submodel = testSubmodel();
        when(mockSubmodelRepository.findBySubmodelName(submodel.getSubmodelName()))
                .thenReturn(Optional.of(submodel));

        serviceToTest.getSubmodel(addPartDto());

        Assertions.assertEquals(testSubmodel().getSubmodelName(), addPartDto().submodelName(),
                "The submodel name is not mapped!");
    }

    @Test
    void getSubmodelAndParts() {
        Submodel submodel = testSubmodel();
        when(mockSubmodelRepository.findBySubmodelName(submodel.getSubmodelName()))
                .thenReturn(Optional.of(submodel));

        Submodel receivedSubmodel = serviceToTest.getSubmodelAndPartsByName(submodel.getSubmodelName());

        Assertions.assertEquals(testSubmodel().getSubmodelName(), receivedSubmodel.getSubmodelName(),
                "The submodel name is not mapped!");
        Assertions.assertEquals(testSubmodel().getSubmodelImage(), receivedSubmodel.getSubmodelImage(),
                "The submodel image is not mapped!");
        Assertions.assertEquals(testSubmodel().getFuel(), receivedSubmodel.getFuel(),
                "The fuel is not mapped!");
    }

    private static AddCarDto addCarDto() {
        return new AddCarDto("Audi", "A5", "Cabrio",
                "cabrio.png", "1.4 Turbo", "249313", 223,
                "03.2014 - 06.2019", String.valueOf(FuelsEnum.PETROL));
    }

    private static AddPartDto addPartDto() {
        return new AddPartDto("Cabrio", "Front axle", "front.png",
                "Braking pads", "Brake pad", "ATE", "333333",
                BigDecimal.valueOf(123));
    }

    private static Model model() {
        Model model = new Model();
        Brand brand = new Brand();

        brand.setBrandName("Audi");
        brand.setBrandImage("audi.png");
        brand.setModels(Set.of(model));

        model.setModelName("A5");

        return model;
    }
    private static Submodel testSubmodel() {
        Submodel submodel = new Submodel();

        submodel.setSubmodelName("Cabrio");
        submodel.setSubmodelImage("cabrio.png");
        submodel.setEngine("1.4 Turbo");
        submodel.setEngineCode("249313");
        submodel.setFuel(FuelsEnum.PETROL);
        submodel.setYear("03.2014 - 06.2019");
        submodel.setHorsePower(223);
        submodel.setModel(model());
        model().getSubmodels().add(submodel);

        Part part = new Part();
        part.setPartName("Front axle");
        part.setPartImage("front.png");
        part.setPrice(BigDecimal.valueOf(123));
        part.setKind("Brake pad");
        part.setManufacturer("ATE");
        part.setGroupName("Braking pads");
        part.setSerialNumber("333333");
        submodel.getParts().add(part);

        return submodel;
    }

}