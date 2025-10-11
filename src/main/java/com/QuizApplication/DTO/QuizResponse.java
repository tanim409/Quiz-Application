package com.QuizApplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizResponse {
    int id;
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String category;
}
