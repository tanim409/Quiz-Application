package com.QuizApplication.controller;

import com.QuizApplication.DTO.progress.LanguageProgressDTO;
import com.QuizApplication.entities.LanguageProgress;
import com.QuizApplication.entities.UserProgress;
import com.QuizApplication.service.LanguageProgressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageProgressController {

    @Autowired
    LanguageProgressService languageProgressService;


    public LanguageProgressDTO storeLanguageProgress(UserProgress userProgress, String language) {
    LanguageProgress languageProgress =  languageProgressService.storeLanguageProgress(userProgress,language);
    return LanguageProgressDTO.languageProgress(languageProgress);
    }

}
