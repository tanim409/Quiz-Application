package com.QuizApplication.service;

import com.QuizApplication.DTO.progress.UserProgressDTO;
import com.QuizApplication.entities.User;
import com.QuizApplication.entities.UserProgress;
import com.QuizApplication.repo.CodingProblemRepo;
import com.QuizApplication.repo.SubmissionRepo;
import com.QuizApplication.repo.UserProgressRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProgressService {
    @Autowired
    UserProgressRepo userProgressRepo;
    @Autowired
    CodingProblemRepo codingProblemRepo;
    @Autowired
    SubmissionRepo submissionRepo;

    public UserProgress trackUserProgress(User user) {

       UserProgress userProgress = userProgressRepo.findByUserId(user.getId());
       Integer totalProblemSolved = submissionRepo.countByUserId(user.getId());
       Integer totalPoints = totalProblemSolved + 10;
       userProgress.setTotalProblemSolved(totalProblemSolved);
       userProgress.setPoints(totalPoints);
       return userProgressRepo.save(userProgress);
    }
}
