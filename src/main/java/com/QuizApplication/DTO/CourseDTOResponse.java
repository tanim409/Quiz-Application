package com.QuizApplication.DTO;

import com.QuizApplication.model.Course;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class CourseDTOResponse {
    public Integer courseId;
    public String courseName;
    public String title;
    public String description;
    public String price;
    public String backImageUrl;
    public String IntroVdoUrl;

    public static CourseDTOResponse courseResponse(Course saveCourse) {
        return new CourseDTOResponse(
                saveCourse.getId(),
                saveCourse.getCourseName(),
                saveCourse.getTitle(),
                saveCourse.getDescription(),
                saveCourse.getPrice(),
                saveCourse.getBackImageUrl(),
                saveCourse.getIntroVdoUrl()

        );
    }


}
