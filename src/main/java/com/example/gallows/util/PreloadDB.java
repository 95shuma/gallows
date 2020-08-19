package com.example.gallows.util;

import com.example.gallows.model.User;
import com.example.gallows.model.Word;
import com.example.gallows.repository.GameRepo;
import com.example.gallows.repository.UserRepo;
import com.example.gallows.repository.WordRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PreloadDB {
    private final PasswordEncoder encoder;

    public PreloadDB(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Bean
    CommandLineRunner initDatabase(UserRepo ur, WordRepo wr, GameRepo gr){
        return (args) -> {
            gr.deleteAll();
            ur.deleteAll();
            wr.deleteAll();
            //------------Тестовые данные--------------
            User user = new User();
            user.setName("admin");
            user.setPassword(encoder.encode("admin"));
            user.setRole("ROLE_ADMIN");
            ur.save(user);
            User user1 = new User();
            user1.setName("user");
            user1.setPassword(encoder.encode("user"));
            ur.save(user1);
            User user2 = User.builder()
                    .name("qwer")
                    .password(encoder.encode("qwer"))
                    .build();
            ur.save(user2);
            Word word = Word.builder()
                    .word("Волк")
                    .description("Лесное животное")
                    .build();
            wr.save(word);
            Word word1 = Word.builder()
                    .word("Огурец")
                    .description("Овощ")
                    .build();
            wr.save(word1);
            Word word2 = Word.builder()
                    .word("Яблоко")
                    .description("Фрукт")
                    .build();
            wr.save(word2);
            System.out.println("http://localhost:7777/");
        };
    }
}
