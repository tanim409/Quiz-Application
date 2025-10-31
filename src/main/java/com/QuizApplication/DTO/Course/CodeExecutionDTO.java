package com.QuizApplication.DTO.Course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeExecutionDTO {

    private String actualOutput;
    private String expectedOutput;
    private String error;
    private boolean passed;
    private Double timeLimit;
    private Double memoryUsed;
    private String status;
    List<TestCaseResultDTO> testCaseResultDTOList;

    public CodeExecutionDTO(List<TestCaseResultDTO> testCaseDTO) {

        this.testCaseResultDTOList = testCaseDTO;
    }
}
