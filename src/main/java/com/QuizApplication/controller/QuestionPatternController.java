package com.QuizApplication.controller;

import com.QuizApplication.DTO.QuestionRequest;
import com.QuizApplication.DTO.QuestionResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.QuizApplication.service.QuestionPatternService;

import java.util.List;

@RestController
@RequestMapping("/getQ")
@Tag(name="Question APIs")
public class QuestionPatternController {

    @Autowired
    QuestionPatternService questionPatternService;

    @GetMapping("/AllQ")
    ResponseEntity<List<QuestionResponse>> getQuestion() {
        return questionPatternService.getQuestion();
    }

    @GetMapping("/AllQ/{category}")
    ResponseEntity<List<QuestionResponse>> getQusByCategory(@PathVariable String category) throws Exception {
        return questionPatternService.getQusByCategory(category);
    }

    @PostMapping("/addQ")
    ResponseEntity<QuestionResponse> AddQuestion(@Valid @RequestBody QuestionRequest question) {
        return questionPatternService.AddQuestion(question);
    }
}
