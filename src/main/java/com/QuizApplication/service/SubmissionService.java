package com.QuizApplication.service;

import com.QuizApplication.DTO.Course.CodeExecutionDTO;
import com.QuizApplication.DTO.Course.CodeSubmissionDTO;
import com.QuizApplication.entities.CodingProblem;
import com.QuizApplication.entities.ProblemSubmission;
import com.QuizApplication.entities.User;
import com.QuizApplication.repo.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionService {

    @Autowired
    SubmissionRepo submissionRepo;

    public void saveCode(User user, CodeExecutionDTO result, CodeSubmissionDTO codeSubmissionDTO, CodingProblem codingProblem) {
        ProblemSubmission problemSubmission = new ProblemSubmission();
        problemSubmission.setUser(user);
        problemSubmission.setCodingProblem(codingProblem);
        problemSubmission.setCode(codeSubmissionDTO.getCode());
        problemSubmission.setLanguage(codeSubmissionDTO.getLanguage());
        problemSubmission.setExecutedTime(result.getTimeLimit());
        problemSubmission.setMemoryUsage(result.getMemoryUsed());
        problemSubmission.setStatus(result.getStatus());
        submissionRepo.save(problemSubmission);
    }
}
