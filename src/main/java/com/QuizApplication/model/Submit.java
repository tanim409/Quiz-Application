package com.QuizApplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Submit {
    @JsonProperty("id")
    Integer quizId;
    String answer;
}
