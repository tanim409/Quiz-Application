package com.QuizApplication.DTO;

import com.QuizApplication.model.Example;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExampleDTO {
Integer Id;
String code;
String output;
String language;
String explanation;

    public static ExampleDTO examResponse(Example example) {
            return new ExampleDTO(
                    example.getId(),
                    example.getCode(),
                    example.getOutput(),
                    example.getLanguage(),
                    example.getExplanation());
    }
}
