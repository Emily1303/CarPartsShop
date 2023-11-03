package org.softuni.carpartsshop.controllers;

import jakarta.validation.Valid;
import org.softuni.carpartsshop.models.dtos.RegisterDto;
import org.softuni.carpartsshop.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/register")
public class RegisterUserController {

    private UserService userService;

    public RegisterUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String register(Model model) {

        if (!model.containsAttribute("registerDto")) {
            model.addAttribute("registerDto", RegisterDto.construct());
        }

        return "register-user";
    }

    @PostMapping
    public String register(@Valid RegisterDto registerDto, BindingResult bindingResult,
                           RedirectAttributes rAttr) {

        if (bindingResult.hasErrors()) {
            rAttr.addFlashAttribute("registerDto", registerDto);
            rAttr.addFlashAttribute("org.springframework.validation.BindingResult.registerDto",
                    bindingResult);

            return "redirect:/register";
        }

        userService.registerUser(registerDto);
        return "redirect:/login";
    }

}
