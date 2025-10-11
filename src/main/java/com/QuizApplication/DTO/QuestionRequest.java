package com.QuizApplication.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class QuestionRequest {

    @NotBlank(message = "question is required")
    String question;
    @NotBlank(message = "option A is required")
    String optionA;
    @NotBlank(message = "option B is required")
    String optionB;
    @NotBlank(message = "option c is required")
    String optionC;
    @NotBlank(message = "option d is required")
    String optionD;
    @NotBlank(message = "answer is required")
    String answer;
    @NotBlank(message = "category is required")
    String category;

    String DifficultyLevel;
}
