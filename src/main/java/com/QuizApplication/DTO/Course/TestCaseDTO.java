package com.QuizApplication.DTO.Course;

import com.QuizApplication.entities.TestCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseDTO {
    private Integer id;
    private String input;
    private String expectedOutput;

    public static TestCaseDTO testcasedto(TestCase testCase) {
        return new TestCaseDTO(
                testCase.getId(),
                testCase.getInput(),
                testCase.getExpectedOutput());
    }
}
