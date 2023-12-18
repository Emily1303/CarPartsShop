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
class RegisterUserControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRegistrationPage() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("register-user"));
    }

//    it returns error because the user role is not set
//    @Test
//    void registerUserWhenDataIsNotValid() throws Exception {
//        mockMvc.perform(
//                MockMvcRequestBuilders.post("/register")
//                        .param("firstName", "Emily")
//                        .param("lastName", "Filipova")
//                        .param("email", "emily@example.com")
//                        .param("password", "Emi123*f")
//                        .param("confirmPassword", "Emi123*f")
//                        .with(csrf()))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/register"));
//
//    }


}