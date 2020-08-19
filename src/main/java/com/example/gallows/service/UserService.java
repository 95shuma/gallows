package com.example.gallows.service;

import com.example.gallows.dto.UserDTO;
import com.example.gallows.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo userRepo;

    public UserDTO getUserByName(String name){
        return UserDTO.from(userRepo.findUserByName(name).get());
    }


}
