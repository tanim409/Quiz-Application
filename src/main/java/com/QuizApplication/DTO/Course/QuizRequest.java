package com.QuizApplication.DTO.Course;

import lombok.Data;

@Data
public class QuizRequest {


    String question;
    String optionA;
    String optionB;
    String optionC;
    String optionD;
    String category;

}
