package com.QuizApplication.controller;

import com.QuizApplication.DTO.Course.CodeExecutionDTO;
import com.QuizApplication.DTO.Course.CodeSubmissionDTO;
import com.QuizApplication.entities.CodingProblem;
import com.QuizApplication.entities.User;
import com.QuizApplication.repo.CodingProblemRepo;
import com.QuizApplication.repo.UserRepo;
import com.QuizApplication.service.ExternalAPI.JdoodleService;
import com.QuizApplication.service.JwtService;
import com.QuizApplication.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CodeExecution {

    @Autowired
    JdoodleService jdoodleService;
    @Autowired
    JwtService jwtService;
    @Autowired
    UserRepo userRepo;
    @Autowired
    SubmissionService submissionService;
    @Autowired
    CodingProblemRepo  codingProblemRepo;

    @PostMapping("/execute")
    public CodeExecutionDTO executeCode(@RequestBody CodeSubmissionDTO codeSubmissionDTO,
                                        @RequestHeader("Authorization")String token) {

       String UserName = jwtService.extractUsername(token.substring(7));
       User user = userRepo.findByUsername(UserName);
       CodingProblem codingProblem = codingProblemRepo.findById(codeSubmissionDTO.getProblemId()).orElse(null);
       CodeExecutionDTO result = jdoodleService.executeCode(codeSubmissionDTO);
       submissionService.saveCode(user,result,codeSubmissionDTO,codingProblem);
       return result;
    }



}
