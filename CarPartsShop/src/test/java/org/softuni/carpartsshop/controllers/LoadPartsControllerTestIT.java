package org.softuni.carpartsshop.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softuni.carpartsshop.models.dtos.forLogic.AddBrandDto;
import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.models.entities.Part;
import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.models.enums.FuelsEnum;
import org.softuni.carpartsshop.repositories.BrandRepository;
import org.softuni.carpartsshop.repositories.ModelRepository;
import org.softuni.carpartsshop.repositories.PartRepository;
import org.softuni.carpartsshop.repositories.SubmodelRepository;
import org.softuni.carpartsshop.services.SubmodelService;
import org.softuni.carpartsshop.services.impl.BrandServiceImpl;
import org.softuni.carpartsshop.services.impl.ModelServiceImpl;
import org.softuni.carpartsshop.services.impl.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class LoadPartsControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BrandServiceImpl brandService;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelServiceImpl modelService;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private SubmodelService submodelService;

    @Autowired
    private SubmodelRepository submodelRepository;

    @Autowired
    private PartServiceImpl partService;

    @Autowired
    private PartRepository partRepository;

    @BeforeEach
    void setUp() {
        partRepository.deleteAll();
        submodelRepository.deleteAll();
        modelRepository.deleteAll();
        brandRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        partRepository.deleteAll();
        submodelRepository.deleteAll();
        modelRepository.deleteAll();
        partRepository.deleteAll();
    }

    @Test
    void getPartsForIndexPage() throws Exception {
        brandService.addNewBrand(addBrandDto());
        Brand brand = brandService.addBrand(addCarDto());

        Model model = new Model();
        model.setModelName("A5");
        model.setBrand(brand);

        brand.getModels().add(model);
        brandRepository.save(brand);

        Submodel submodel = testSubmodel();
        submodel.setModel(model);
        model.getSubmodels().add(submodel);
        modelRepository.save(model);

        Part part = testPart();
        submodel.getParts().add(part);
        submodelRepository.save(submodel);

        part.getSubmodel().add(submodel);
        partRepository.save(part);

        Submodel receivedSubmodel = submodelService.getSubmodelAndPartsByName(submodel.getSubmodelName());
        List<Part> parts = receivedSubmodel.getParts();
        List<Part> allParts = partService.getAllPartsByGroupNameAndSubmodel(part.getGroupName(), parts);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/{name}/parts/{submodel}/{group}",
                        brand.getBrandName(), submodel.getSubmodelName(), part.getGroupName()))
                .andExpect(status().isOk())
                .andExpect(view().name("show-parts"));
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    void getPartsForHomePage() throws Exception {
        brandService.addNewBrand(addBrandDto());
        Brand brand = brandService.addBrand(addCarDto());

        Model model = new Model();
        model.setModelName("A5");
        model.setBrand(brand);

        brand.getModels().add(model);
        brandRepository.save(brand);

        Submodel submodel = testSubmodel();
        submodel.setModel(model);
        model.getSubmodels().add(submodel);
        modelRepository.save(model);

        Part part = testPart();
        submodel.getParts().add(part);
        submodelRepository.save(submodel);

        part.getSubmodel().add(submodel);
        partRepository.save(part);

        Submodel receivedSubmodel = submodelService.getSubmodelAndPartsByName(submodel.getSubmodelName());
        List<Part> parts = receivedSubmodel.getParts();
        List<Part> allParts = partService.getAllPartsByGroupNameAndSubmodel(part.getGroupName(), parts);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/home/{name}/parts/{submodel}/{group}",
                                brand.getBrandName(), submodel.getSubmodelName(), part.getGroupName()))
                .andExpect(status().isOk())
                .andExpect(view().name("show-parts"));
    }

    private static AddBrandDto addBrandDto() {
        return new AddBrandDto("Audi", "audi.png");
    }

    private static AddCarDto addCarDto() {
        return new AddCarDto("Audi", "A5", "Cabrio",
                "cabrio.png", "1.4 Turbo", "249313", 223,
                "03.2014 - 06.2019", String.valueOf(FuelsEnum.PETROL));
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

        return submodel;
    }

    private static Part testPart() {
        Part part = new Part();

        part.setPartName("Front axle");
        part.setPartImage("front.png");
        part.setPrice(BigDecimal.valueOf(123));
        part.setKind("Brake pad");
        part.setAvailable(true);
        part.setManufacturer("ATE");
        part.setGroupName("Braking pads");
        part.setSerialNumber("333333");

        return part;
    }

}