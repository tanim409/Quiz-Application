package com.QuizApplication.DTO.Course;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CourseDTORequest {
    private String courseName;
    private String title;
    private String description;
    private String price;
    private String backImageUrl;
    private String IntroVdoUrl;
}
