package com.example.gallows.dto;

import com.example.gallows.model.Word;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WordDTO {
    private String word;
    private String description;

    public WordDTO from (Word word) {
        return WordDTO.builder()
                .word(word.getWord())
                .description(word.getDescription())
                .build();
    }
}
