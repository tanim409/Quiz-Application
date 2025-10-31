package com.QuizApplication.DTO.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponse {
    int id;
    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String category;

}
