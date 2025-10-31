package com.QuizApplication.service;

import com.QuizApplication.DTO.progress.LanguageProgressDTO;

import com.QuizApplication.entities.LanguageProgress;
import com.QuizApplication.entities.UserProgress;
import com.QuizApplication.repo.CodingProblemRepo;
import com.QuizApplication.repo.LanguageProgressRepo;
import com.QuizApplication.repo.SubmissionRepo;
import com.QuizApplication.repo.UserProgressRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageProgressService {
    @Autowired
    LanguageProgressRepo languageProgressRepo;
    @Autowired
    UserProgressRepo userProgressRepo;
    @Autowired
    SubmissionRepo submissionRepo;
    @Autowired
    CodingProblemRepo codingProblemRepo;


    public LanguageProgress storeLanguageProgress(UserProgress userProgress,String language) {
        Integer userId = userProgress.getUser().getId();
        LanguageProgress languageProgress = languageProgressRepo.findByLanguageAndUserId(userProgress.getUser().getId(),language);
        Integer problemSolved = submissionRepo.countSolvedProblemByUserAndLanguage(userId,language);
        Integer totalProblem = codingProblemRepo.countByLanguage(language);
        languageProgress.setTotalProblems(totalProblem);
        languageProgress.setUserProgress(userProgress);
        languageProgress.setLanguage(language);
        languageProgress.setTotalProblemsSolved(problemSolved);


        return languageProgressRepo.save(languageProgress);
    }
}
