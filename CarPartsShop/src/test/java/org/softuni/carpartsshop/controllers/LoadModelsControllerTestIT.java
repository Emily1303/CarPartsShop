package org.softuni.carpartsshop.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.softuni.carpartsshop.models.dtos.forLogic.AddBrandDto;
import org.softuni.carpartsshop.models.entities.Brand;
import org.softuni.carpartsshop.models.entities.Model;
import org.softuni.carpartsshop.repositories.BrandRepository;
import org.softuni.carpartsshop.services.impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class LoadModelsControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BrandServiceImpl brandService;

    @Mock
    private BrandRepository mockBrandRepository;

//    @Test
//    void getModelForIndexPage() throws Exception {
//        Brand brand = new Brand();
//        brand.setBrandName(addBrandDto().nameBrand());
//        brand.setBrandImage(addBrandDto().brandImage());
//
//        Model model = new Model();
//        model.setModelName("A5");
//        brand.getModels().add(model);
//
//        when(mockBrandRepository.findByBrandName(addBrandDto().nameBrand()))
//                .thenReturn(Optional.of(brand));
//
//        Set<Model> allModels = brandService.getAllModelsByBrandName(brand.getBrandName());
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/{name}", addBrandDto().nameBrand()))
//                .andExpect(status().isOk())
//                .andExpect(view().name("submodels"));
//    }

    private static AddBrandDto addBrandDto() {
        return new AddBrandDto("Audi", "audi.png");
    }

}