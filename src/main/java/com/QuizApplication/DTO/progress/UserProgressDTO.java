package com.QuizApplication.DTO.progress;

import com.QuizApplication.entities.LanguageProgress;
import com.QuizApplication.entities.SkillProgress;
import com.QuizApplication.entities.UserProgress;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserProgressDTO {

    private Integer totalProblemSolved;
    private Integer points;


    public static UserProgressDTO getUserProgress(UserProgress userProgress) {
                return new UserProgressDTO(userProgress.getTotalProblemSolved(),
                        userProgress.getPoints());
    }
}
