package com.QuizApplication.DTO.Course;

import lombok.Data;
import org.hibernate.result.Output;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;

import java.time.LocalDateTime;

@Data
public class TestCaseResultDTO {
    private Integer id;
    private String input;
    private String actualOutput;
    private String expectedOutput;
    private Boolean passed;
    private String status;
    private String error;
    private String statusCode;

    private Double timeLimit;
    private Double memoryLimit;

}
