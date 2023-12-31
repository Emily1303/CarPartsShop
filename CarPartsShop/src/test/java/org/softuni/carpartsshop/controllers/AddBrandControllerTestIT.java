package org.softuni.carpartsshop.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class AddBrandControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void getAddBrandPage() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/add/brand"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-brand"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void addBrandPost() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/add/brand")
                        .param("nameBrand", "Audi")
                        .param("brandImage", "audi.png")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/add/car"));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void addBrandPostNotValid() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/add/brand")
                                .param("nameBrand", "A")
                                .param("brandImage", "audi.png")
                                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/add/brand"));
    }

}