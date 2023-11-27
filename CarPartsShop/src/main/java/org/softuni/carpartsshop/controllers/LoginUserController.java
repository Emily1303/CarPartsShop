package org.softuni.carpartsshop.controllers;

import jakarta.validation.Valid;
import org.softuni.carpartsshop.models.dtos.forLogic.LoginDto;
import org.softuni.carpartsshop.services.UserService;
import org.softuni.carpartsshop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
public class LoginUserController {

    private final UserService userService;

    private final CurrentUser currentUser;

    public LoginUserController(UserService userService, CurrentUser currentUser) {
        this.userService = userService;
        this.currentUser = currentUser;
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

        UUID uuid = userService.getUuid(loginDto);

        return userService.loginUser(loginDto) ? "redirect:/" + uuid + "/home" : "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout() {
        if (!currentUser.isLogged()) {
            return "redirect:/login";
        }

        userService.logout();
        return "redirect:/";
    }

}
