package com.example.gallows.dto;

import com.example.gallows.model.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDTO {
    private Integer id;
    private String name;
    private String password;
    private String role = "ROLE_USER";

    public static UserDTO from (User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
}
