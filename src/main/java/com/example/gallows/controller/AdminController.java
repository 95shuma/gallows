package com.example.gallows.controller;

import com.example.gallows.dto.UserDTO;
import com.example.gallows.dto.WordDTO;
import com.example.gallows.service.GameService;
import com.example.gallows.service.UserService;
import com.example.gallows.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
    private WordService wordService;
    private UserService userService;
    private GameService gameService;

    //-------Отображение общей статистики----------
    @GetMapping("/all-stat")
    public String getAllStat(Model model) {
        model.addAttribute("games",gameService.getAllStat());
        return "allStat";
    }

    //-------Добавление слова----------
    @PostMapping("/add-word")
    public String addWord(WordDTO wordDTO) {
        wordService.saveWord(wordDTO);
        return "redirect:/";
    }

    //-------Добавление пользователя----------
    @PostMapping("/add-user")
    public String addUser(UserDTO userDTO) {
        userService.saveUser(userDTO);
        return "redirect:/";
    }
}
