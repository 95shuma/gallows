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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/stat")
    public String getStat(Model model, Principal principal){
        UserDTO userDTO = userService.getUserByName(principal.getName());
        model.addAttribute("games",gameService.findGamesByUserId(userDTO.getId()));
        return "userStat";
    }

    @PostMapping("/check-letter")
    public String checkLetter(RedirectAttributes attributes,
                              @RequestParam("game_id") Integer game_id,
                              @RequestParam("letter") String letter) {
        GameDTO gameDTO = gameService.findGameById(game_id);
        if (gameDTO.getWordDTO().getWord().toUpperCase().indexOf(letter)>=0){
            GameDTO gameDTO1 = gameService.userFindLetter(letter, game_id);
            if(gameDTO1.getWordDTO().getWord().toUpperCase().equals(gameDTO1.getUser_word())){
                attributes.addFlashAttribute("word",gameDTO1.getUser_word());
                attributes.addFlashAttribute("points",gameDTO1.getPoints());
                return "redirect:/user/win";
            }
            attributes.addFlashAttribute("game",gameDTO1);
            attributes.addFlashAttribute("letters",gameDTO1.getUsed_letters().split(""));
            attributes.addFlashAttribute("word_let",gameDTO1.getUser_word().split(""));
            return "redirect:/user/game/continue";
        } else {
            if (gameDTO.getAttempts()>0){
                GameDTO gameDTO1 = gameService.userNotFindLetter(letter,game_id);
                attributes.addFlashAttribute("game",gameDTO1);
                attributes.addFlashAttribute("letters",gameDTO1.getUsed_letters().split(""));
                attributes.addFlashAttribute("word_let",gameDTO1.getUser_word().split(""));
                return "redirect:/user/game/continue";
            } else {
                attributes.addFlashAttribute("word",gameDTO.getWordDTO().getWord());
                return "redirect:/user/lose";
            }
        }
    }
}
