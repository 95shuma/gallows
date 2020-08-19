package com.example.gallows.dto;

import com.example.gallows.model.Game;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GameDTO {
    private UserDTO userDTO;
    private WordDTO wordDTO;
    private Integer attempts;
    private Integer points;
    private String used_letters;
    private String user_word;

    public static GameDTO from(Game game){
        return GameDTO.builder()
                .userDTO(UserDTO.from(game.getUser()))
                .wordDTO(WordDTO.from(game.getWord()))
                .attempts(game.getAttempts())
                .points(game.getPoints())
                .used_letters(game.getUsed_letters())
                .user_word(game.getUser_word())
                .build();
    }
}
