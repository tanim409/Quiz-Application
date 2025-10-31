package com.QuizApplication.DTO.Course;

import com.QuizApplication.entities.Tutorial;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TutorialDTO {

    Integer id;
    String videoUrl;

    public static TutorialDTO tutorialResponse(Tutorial tutorial) {
        return new TutorialDTO(tutorial.getId(),tutorial.getVideoUrl());
    }
}
