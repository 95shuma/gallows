package com.example.gallows.controller;

import com.example.gallows.dto.UserDTO;
import com.example.gallows.dto.WordDTO;
import com.example.gallows.service.UserService;
import com.example.gallows.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private WordService wordService;
    private UserService userService;

    @PostMapping("/add-word")
    public String addWord(WordDTO wordDTO) {
        wordService.saveWord(wordDTO);
        return "redirect:/";
    }

    @PostMapping("/add-user")
    public String addUser(UserDTO userDTO) {
        userService.saveUser(userDTO);
        return "redirect:/";
    }
}
