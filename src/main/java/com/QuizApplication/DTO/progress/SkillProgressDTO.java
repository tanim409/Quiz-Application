package com.QuizApplication.DTO.progress;

import com.QuizApplication.entities.Difficulty;
import com.QuizApplication.entities.SkillProgress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillProgressDTO {
    private String category;
    private Difficulty difficulty;
    private Integer totalProblemSolved;
    private Integer totalProblems;

    public static SkillProgressDTO getSkillProgress(SkillProgress skillProgress) {
        return new SkillProgressDTO(skillProgress.getCategory(),
                         skillProgress.getDifficulty(),
                         skillProgress.getTotalProblemSolved(),
                         skillProgress.getTotalProblems());
    }
}
