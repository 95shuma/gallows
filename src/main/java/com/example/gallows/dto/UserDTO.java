package com.example.gallows.dto;

import com.example.gallows.model.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDTO {
    private String name;
    private String password;

    public UserDTO from (User user) {
        return UserDTO.builder()
                .name(user.getName())
                .password(user.getPassword())
                .build();
    }
}
