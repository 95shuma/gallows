package com.example.gallows.service;

import com.example.gallows.dto.WordDTO;
import com.example.gallows.model.Word;
import com.example.gallows.repository.WordRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class WordService {
    private WordRepo wordRepo;

    public void saveWord(WordDTO wordDTO){
        wordRepo.save(Word.builder()
                .word(wordDTO.getWord())
                .description(wordDTO.getDescription())
                .build());
    }

    public WordDTO getRandomWord(){
        Random random = new Random();
        List<Word> words = wordRepo.findAll();
        return WordDTO.from(words.get(random.nextInt(words.size())));
    }
}
