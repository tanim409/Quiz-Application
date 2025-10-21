package com.QuizApplication.DTO;

import com.QuizApplication.model.Question;
import com.QuizApplication.model.Quiz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
