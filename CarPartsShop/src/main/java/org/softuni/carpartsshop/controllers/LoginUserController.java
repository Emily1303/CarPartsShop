package org.softuni.carpartsshop.controllers;

import jakarta.validation.Valid;
import org.softuni.carpartsshop.models.dtos.LoginDto;
import org.softuni.carpartsshop.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginUserController {

    private UserService userService;

    public LoginUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {

        if (!model.containsAttribute("loginDto")) {
            model.addAttribute("loginDto", LoginDto.construct());
        }

        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid LoginDto loginDto, BindingResult bindingResult,
                        RedirectAttributes rAttr) {

        if (bindingResult.hasErrors()) {
            rAttr.addFlashAttribute("loginDto", loginDto);
            rAttr.addFlashAttribute("org.springframework.validation.BindingResult.loginDto",
                    bindingResult);

            return "redirect:/login";
        }

        return userService.loginUser(loginDto) ? "redirect:/home" : "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();

        return "redirect:/";
    }

}
