package com.example.gallows.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20)
    private String name;

    @Column(length = 5)
    @Builder.Default
    private String role = "ROLE_USER";

    @Column(length = 20)
    private String password;

    @Column
    @Builder.Default
    private Boolean enabled = true;
}
