package com.example.gallows.service;

import com.example.gallows.dto.GameDTO;
import com.example.gallows.dto.UserDTO;
import com.example.gallows.dto.WordDTO;
import com.example.gallows.model.Game;
import com.example.gallows.model.User;
import com.example.gallows.model.UserPoint;
import com.example.gallows.repository.GameRepo;
import com.example.gallows.repository.UserRepo;
import com.example.gallows.repository.WordRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

@Service
@AllArgsConstructor
public class GameService {
    private GameRepo gameRepo;
    private UserRepo userRepo;
    private WordRepo wordRepo;

    public GameDTO saveGame(UserDTO userDTO, WordDTO wordDTO){
        String userWord = "";
        for(int i=0; i<wordDTO.getWord().length();i++){
            userWord = userWord.concat("*");
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

    public GameDTO findGameById(Integer id){
        return GameDTO.from(gameRepo.findById(id).get());
    }

    public GameDTO userFindLetter(String letter, Integer gameId){
        Game game = gameRepo.findById(gameId).get();

        String[] word = game.getWord().getWord().split("");
        String[] userWord =  game.getUser_word().split("");
        String[] letters = game.getUsed_letters().split("");

        for (int i=0; i<word.length; i++){
            if(word[i].toUpperCase().equals(letter)) {
                userWord[i] = letter;
                game.setPoints(game.getPoints()+1);
            }
        }

        for (int i=0; i<letters.length; i++) {
            if(letters[i].equals(letter))
                letters[i]="";
        }

        game.setUser_word(Arrays.stream(userWord).collect(Collectors.joining()));
        game.setUsed_letters(Arrays.stream(letters).collect(Collectors.joining()));

        gameRepo.save(game);

        return GameDTO.from(game);
    }

    public GameDTO userNotFindLetter(String letter, Integer gameId){
        Game game = gameRepo.findById(gameId).get();

        game.setAttempts(game.getAttempts()-1);

        game.setPoints(game.getPoints()-1);

        String[] letters = game.getUsed_letters().split("");

        for (int i=0; i<letters.length; i++) {
            if(letters[i].equals(letter))
                letters[i]="";
        }

        game.setUsed_letters(Arrays.stream(letters).collect(Collectors.joining()));

        gameRepo.save(game);

        return GameDTO.from(game);
    }

    public List<GameDTO> findGamesByUserId(Integer id){
        List<Game> games = gameRepo.findGamesByUserId(id);
        return games.stream().map(game -> GameDTO.from(game)).collect(Collectors.toList());
    }

    public List<UserPoint> getAllStat(){
        List<Game> games = gameRepo.findAll();
        Map<User, Integer> userPoints = games.stream()
                .collect(groupingBy(Game::getUser, summingInt(Game::getPoints)));
        List<User> user = new ArrayList(userPoints.keySet());
        List<Integer> points =  new ArrayList(userPoints.values());
        List<UserPoint> userPointsEnd = new ArrayList<>();
        for (int i=0; i<user.size(); i++) {
            userPointsEnd.add(new UserPoint(user.get(i).getName(), points.get(i)));
        }
        return userPointsEnd;
    }
}
