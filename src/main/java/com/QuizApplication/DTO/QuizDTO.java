package com.QuizApplication.DTO;

import com.QuizApplication.model.Quiz;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizDTO {
    public Integer id;
    public String category;

    public static QuizDTO quizDTO(Quiz quiz) {
        return new QuizDTO(quiz.getId(), quiz.getCategory());
    }
}
