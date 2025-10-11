package com.QuizApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @NotBlank(message = "username is required")
    @Size(min = 3,max = 20, message = "username must be between 3 to 20")
    @Column(unique = true)
    String username;
    @NotBlank(message = "password is required")
    @Size(min = 6,message = "password must be at least 6 character ")
    @Column(unique = true)
    String password;
    String email;
}
