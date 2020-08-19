package com.example.gallows.controller;

import com.example.gallows.dto.UserDTO;
import com.example.gallows.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class LoginController {
    private UserService userService;

    //--------Отображение главной страницы---------
    @GetMapping("/")
    public String getMainPage(Model model, Principal principal) {
        UserDTO userDTO = userService.getUserByName(principal.getName());
        model.addAttribute("person",userDTO);
        if (userDTO.getRole().equals("ROLE_ADMIN")){
            model.addAttribute("admin", true);
        } else {
            model.addAttribute("user", true);
        }
        return "main";
    }
}
