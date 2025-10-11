package com.QuizApplication.DTO;

import lombok.Data;

@Data
public class QuestionResponse {

    int id;
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String answer;
    String category;
    String DifficultyLevel;
}
