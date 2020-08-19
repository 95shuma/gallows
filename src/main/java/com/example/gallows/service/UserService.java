package com.example.gallows.service;

import com.example.gallows.dto.UserDTO;
import com.example.gallows.model.User;
import com.example.gallows.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo userRepo;
    private final PasswordEncoder encoder;

    //------------Найти пользователя по имени--------------
    public UserDTO getUserByName(String name){
        return UserDTO.from(userRepo.findUserByName(name).get());
    }

    //------------Сохранить пользователя--------------
    public void saveUser(UserDTO userDTO){
        userRepo.save(User.builder()
                .name(userDTO.getName())
                .password(encoder.encode(userDTO.getPassword()))
                .build());
    }
}
