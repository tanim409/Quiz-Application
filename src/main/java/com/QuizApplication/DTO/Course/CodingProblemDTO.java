package com.QuizApplication.DTO.Course;

import com.QuizApplication.entities.CodingProblem;
import com.QuizApplication.entities.Difficulty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodingProblemDTO {
    private String title;
    private String description;
    private String language;
    private String category;
    private Difficulty difficulty;
    private Integer timeLimit;
    private Integer memoryLimit;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;



    public static CodingProblemDTO codingProblemForCourse(CodingProblem problemForCourse) {
        return new CodingProblemDTO(problemForCourse.getTitle(),
                problemForCourse.getDescription(),
                problemForCourse.getLanguage(),
                problemForCourse.getCategory(),
                problemForCourse.getDifficulty(),
                problemForCourse.getTimeLimit(),
                problemForCourse.getMemoryLimit(),
                problemForCourse.getCreationDate(),
                problemForCourse.getUpdateDate());
    }
}



