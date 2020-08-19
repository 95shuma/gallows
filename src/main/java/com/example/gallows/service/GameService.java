package com.example.gallows.service;

import com.example.gallows.dto.GameDTO;
import com.example.gallows.dto.UserDTO;
import com.example.gallows.dto.WordDTO;
import com.example.gallows.model.Game;
import com.example.gallows.repository.GameRepo;
import com.example.gallows.repository.UserRepo;
import com.example.gallows.repository.WordRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {
    private GameRepo gameRepo;
    private UserRepo userRepo;
    private WordRepo wordRepo;

    public GameDTO saveGame(UserDTO userDTO, WordDTO wordDTO){
        String userWord = "";
        for(int i=0; i<wordDTO.getWord().length();i++){
            userWord.concat("*");
        }
        Game game = Game.builder()
                .user(userRepo.findUserByName(userDTO.getName()).get())
                .word(wordRepo.findWordByWordAndDescription(wordDTO.getWord(),wordDTO.getDescription()).get())
                .attempts(wordDTO.getWord().length()-2)
                .points(0)
                .user_word(userWord)
        .build();
        gameRepo.save(game);
        return GameDTO.from(game);
    }
}
