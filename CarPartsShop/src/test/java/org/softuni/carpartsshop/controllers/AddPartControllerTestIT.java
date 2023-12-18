package org.softuni.carpartsshop.controllers;

import org.junit.jupiter.api.Test;
import org.softuni.carpartsshop.models.dtos.forLogic.AddPartDto;
import org.softuni.carpartsshop.models.entities.Part;
import org.softuni.carpartsshop.models.entities.Submodel;
import org.softuni.carpartsshop.services.impl.PartServiceImpl;
import org.softuni.carpartsshop.services.impl.SubmodelServiceImpl;
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
class AddPartControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SubmodelServiceImpl submodelService;

    @Autowired
    private PartServiceImpl partService;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void getAddPartPage() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/add/parts"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-parts"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void addPartPost() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.post("/add/parts")
                        .param("submodelName", "Cabrio")
                        .param("partName", "Front axle")
                        .param("partImage", "front.png")
                        .param("groupName", "Braking pads")
                        .param("kind", "Brake pad")
                        .param("manufacturer", "ATE")
                        .param("serialNumber", "333333")
                        .param("price", String.valueOf(BigDecimal.valueOf(123)))
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/home"));
    }

    private static AddPartDto addPartDto() {
        return new AddPartDto("Cabrio", "Front axle", "front.png",
                "Braking pads", "Brake pad", "ATE", "333333",
                BigDecimal.valueOf(123));
    }

}