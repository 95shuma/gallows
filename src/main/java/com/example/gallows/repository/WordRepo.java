package com.example.gallows.repository;

import com.example.gallows.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepo extends JpaRepository<Word, Integer> {
}
