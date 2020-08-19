package com.example.gallows.repository;

import com.example.gallows.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WordRepo extends JpaRepository<Word, Integer> {
    Optional<Word> findWordByWordAndDescription(String word, String description);
}
