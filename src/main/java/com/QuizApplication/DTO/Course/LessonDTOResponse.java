package com.QuizApplication.DTO.Course;

import com.QuizApplication.entities.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LessonDTOResponse {
  private Integer id;
  private String title;
  private String description;

  public static LessonDTOResponse lessonResponse(Lesson lesson) {
        return new LessonDTOResponse(lesson.getId(),lesson.getTitle(),lesson.getDescription());
    }
}
