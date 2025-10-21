package com.QuizApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String answer;
    String category;
    String DifficultyLevel;


}


