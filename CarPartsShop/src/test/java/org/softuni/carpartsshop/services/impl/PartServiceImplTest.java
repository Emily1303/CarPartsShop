package org.softuni.carpartsshop.services.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.softuni.carpartsshop.models.dtos.forLogic.AddPartDto;
import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.repositories.PartRepository;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PartServiceImplTest {

    private PartServiceImpl serviceToTest;

    @Mock
    private PartRepository mockPartRepository;

    @BeforeEach
    void setUp() {
        serviceToTest = new PartServiceImpl(mockPartRepository);
    }

    @Test
    void addPart() {
        Submodel submodel = new Submodel();
        submodel.setSubmodelName("Cabrio");

        serviceToTest.addPart(addPartDto(), submodel);
    }

    private static AddPartDto addPartDto() {
        return new AddPartDto("Cabrio", "Front axle", "front.png",
                "Braking pads", "Brake pad", "ATE", "333333",
                BigDecimal.valueOf(123));
    }

}