package org.softuni.carpartsshop.controllers;

import org.junit.jupiter.api.Test;
import org.softuni.carpartsshop.models.enums.FuelsEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class AddCarControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void getAddCarPage() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/add/car"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-car"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void addCarPost() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/add/car")
                        .param("brandName", "Audi")
                        .param("modelName", "A5")
                        .param("submodelName", "Cabrio")
                        .param("submodelImage", "cabrio.png")
                        .param("engine", "1.4 Turbo")
                        .param("engineCode", "249313")
                        .param("horsePower", String.valueOf(BigDecimal.valueOf(223)))
                        .param("year", "03.2014 - 06.2019")
                        .param("fuel", String.valueOf(FuelsEnum.PETROL))
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/add/parts"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void addCarPostNotValid() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/add/car")
                                .param("brandName", "Audi")
                                .param("modelName", "A5")
                                .param("submodelName", "")
                                .param("submodelImage", "cabrio.png")
                                .param("engine", "1.4 Turbo")
                                .param("engineCode", "249313")
                                .param("horsePower", String.valueOf(BigDecimal.valueOf(223)))
                                .param("year", "03.2014 - 06.2019")
                                .param("fuel", String.valueOf(FuelsEnum.PETROL))
                                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/add/car"));
    }

}