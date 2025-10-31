package com.QuizApplication.DTO.Course;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeSubmissionDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer problemId;
    private String code;
    private String language;
    private String category;


}
