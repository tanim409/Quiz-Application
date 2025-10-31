package com.QuizApplication.controller;

import com.QuizApplication.DTO.progress.SkillProgressDTO;
import com.QuizApplication.entities.SkillProgress;
import com.QuizApplication.entities.UserProgress;
import com.QuizApplication.service.SkillProgressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillProgressController {
    @Autowired
    SkillProgressService skillProgressService;


    public SkillProgressDTO addSkillProgress(@RequestBody UserProgress userProgress,String Category) {
        SkillProgress skillProgress = skillProgressService.addSkillProgress(userProgress,Category);
        return SkillProgressDTO.getSkillProgress(skillProgress);
    }



}
