package com.QuizApplication.controller;

import com.QuizApplication.DTO.progress.UserProgressDTO;
import com.QuizApplication.entities.UserProgress;
import com.QuizApplication.service.UserProgressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.QuizApplication.entities.User;

@RestController
public class UserProgressController {
    @Autowired
    UserProgressService userProgressService;

    @GetMapping("/Progress")
    public UserProgressDTO trackUserProgress(User user) {
        UserProgress userProgress = userProgressService.trackUserProgress(user);
        return UserProgressDTO.getUserProgress(userProgress);
    }

}
