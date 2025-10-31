package com.QuizApplication.DTO.progress;


import com.QuizApplication.entities.LanguageProgress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageProgressDTO {
    private String language;
    private Integer totalProblemsSolved;
    private Integer totalProblems;

    public static LanguageProgressDTO languageProgress(LanguageProgress languageProgress) {
        return new LanguageProgressDTO(
                languageProgress.getLanguage(),
                languageProgress.getTotalProblemsSolved(),
                languageProgress.getTotalProblems());
    }
}
