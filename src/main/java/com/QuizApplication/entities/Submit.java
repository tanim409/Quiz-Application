package com.QuizApplication.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Submit {
    @JsonProperty("id")
    Integer quizId;
    String answer;
}
