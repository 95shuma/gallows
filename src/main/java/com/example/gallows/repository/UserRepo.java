package com.example.gallows.repository;

import com.example.gallows.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo  extends JpaRepository<User, Integer> {
}
