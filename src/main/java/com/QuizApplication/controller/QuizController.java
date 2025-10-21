package com.QuizApplication.controller;


import com.QuizApplication.DTO.QuizRequest;
import com.QuizApplication.DTO.QuizResponse;
import com.QuizApplication.model.Submit;
import com.QuizApplication.service.QuizService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Quiz")
@Tag(name ="Quiz APIs")
public class QuizController {

    QuizService quizService;
    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/insert/{category}")
    ResponseEntity<String> insertQuiz(@PathVariable String category) {
    return quizService.insertQuiz(category);
    }

    @GetMapping("/getQues/{category}")
    List<QuizResponse> quizResponse(@PathVariable String category) throws Exception {

        return quizService.quizResponse(category);
    }
    @PostMapping("/submit/{category}")
    ResponseEntity<Integer> submitQuiz(@PathVariable String category,@Valid @RequestBody List<Submit> response) throws Exception {
        return quizService.submitQuiz(category,response);
    }

}
