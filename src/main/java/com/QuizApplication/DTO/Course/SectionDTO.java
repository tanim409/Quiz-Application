package com.QuizApplication.DTO.Course;

import com.QuizApplication.entities.Section;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SectionDTO {
    private Integer id;
    private String title;
    private String content;
    private String imageUrl;


    public static SectionDTO sectionResponse(Section section) {
        return new SectionDTO(
                section.getId(),
                section.getTitle(),
                section.getContent(),
                section.getImageUrl());

    }
}
