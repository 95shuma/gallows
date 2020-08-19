package com.example.gallows.controller;

import com.example.gallows.dto.GameDTO;
import com.example.gallows.dto.UserDTO;
import com.example.gallows.dto.WordDTO;
import com.example.gallows.service.GameService;
import com.example.gallows.service.UserService;
import com.example.gallows.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private WordService wordService;
    private GameService gameService;

    @GetMapping("/game")
    public String play(Model model, Principal principal) {
        UserDTO userDTO = userService.getUserByName(principal.getName());
        WordDTO wordDTO = wordService.getRandomWord();
        GameDTO gameDTO = gameService.saveGame(userDTO,wordDTO);
        model.addAttribute("game",gameDTO);
        model.addAttribute("letters",gameDTO.getUsed_letters().split(""));
        model.addAttribute("word_let",gameDTO.getUser_word().split(""));
        return "game";
    }

    @GetMapping("/game/continue")
    public String continuePlay(){
        return "game";
    }

    @GetMapping("/win")
    public String getWinPage(){
        return "winPage";
    }

    @GetMapping("/lose")
    public String getLosePage(){
        return "losePage";
    }


}
