package org.softuni.carpartsshop.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softuni.carpartsshop.models.dtos.forLogic.AddBrandDto;
import org.softuni.carpartsshop.models.dtos.forLogic.AddCarDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.models.enums.FuelsEnum;
import org.softuni.carpartsshop.repositories.BrandRepository;
import org.softuni.carpartsshop.repositories.ModelRepository;
import org.softuni.carpartsshop.services.impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class LoadModelsControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BrandServiceImpl brandService;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    @BeforeEach
    void setUp() {
        modelRepository.deleteAll();
        brandRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
        modelRepository.deleteAll();
        brandRepository.deleteAll();
    }

    @Test
    void getModelsForIndexPage() throws Exception {
        brandService.addNewBrand(addBrandDto());
        Brand brand = brandService.addBrand(addCarDto());

        Model model = new Model();
        model.setModelName("A5");
        model.setBrand(brand);
        modelRepository.save(model);

        brand.getModels().add(model);
        brandRepository.save(brand);

        Set<Model> allModels = brandService.getAllModelsByBrandName(brand.getBrandName());

        mockMvc.perform(
                MockMvcRequestBuilders.get("/{name}", brand.getBrandName()))
                .andExpect(status().isOk())
                .andExpect(view().name("submodels"));
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    void getModelsForHomePage() throws Exception {
        brandService.addNewBrand(addBrandDto());
        Brand brand = brandService.addBrand(addCarDto());

        Model model = new Model();
        model.setModelName("A5");
        model.setBrand(brand);
        modelRepository.save(model);

        brand.getModels().add(model);
        brandRepository.save(brand);

        Set<Model> allModels = brandService.getAllModelsByBrandName(brand.getBrandName());

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/home/{name}", brand.getBrandName()))
                .andExpect(status().isOk())
                .andExpect(view().name("submodels-home-page"));
    }

    private static AddBrandDto addBrandDto() {
        return new AddBrandDto("Audi", "audi.png");
    }

    private static AddCarDto addCarDto() {
        return new AddCarDto("Audi", "A5", "Cabrio",
                "cabrio.png", "1.4 Turbo", "249313", 223,
                "03.2014 - 06.2019", String.valueOf(FuelsEnum.PETROL));
    }

}