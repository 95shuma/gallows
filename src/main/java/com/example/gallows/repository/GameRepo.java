package com.example.gallows.repository;

import com.example.gallows.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepo extends JpaRepository<Game, Integer> {
    List<Game> findGamesByUserId(Integer id);
}
