package com.example.gallows.repository;

import com.example.gallows.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepo extends JpaRepository<Game, Integer> {
}
