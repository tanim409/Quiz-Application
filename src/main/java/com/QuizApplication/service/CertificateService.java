package com.QuizApplication.service;

import com.QuizApplication.DTO.Course.CodingProblemDTO;
import com.QuizApplication.DTO.Course.TestCaseDTO;
import com.QuizApplication.DTO.TasksForCertificate.CertificateCompetitionDTO;
import com.QuizApplication.entities.CodingProblem;
import com.QuizApplication.entities.CertificateCompetition;
import com.QuizApplication.entities.TestCase;
import com.QuizApplication.repo.CertificateCompetitionRepo;
import com.QuizApplication.repo.CodingProblemRepo;
import com.QuizApplication.repo.TestCaseRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificateService {

    @Autowired
    CodingProblemRepo codingProblemRepo;
    @Autowired
    TestCaseRepo testCaseRepo;
    @Autowired
    CertificateCompetitionRepo certificateCompetitionRepo;

    public CodingProblem addCodingProblem(@Valid CodingProblemDTO codingProblemForCourseDTO) {
        CodingProblem codingProblem = new CodingProblem();
        codingProblem.setTitle(codingProblemForCourseDTO.getTitle());
        codingProblem.setDescription(codingProblemForCourseDTO.getDescription());
        codingProblem.setLanguage(codingProblemForCourseDTO.getLanguage());
        codingProblem.setTimeLimit(codingProblemForCourseDTO.getTimeLimit());
        codingProblem.setMemoryLimit(codingProblemForCourseDTO.getMemoryLimit());
        codingProblem.setCreationDate(codingProblemForCourseDTO.getCreationDate());
        codingProblem.setUpdateDate(codingProblemForCourseDTO.getUpdateDate());

        return codingProblemRepo.save(codingProblem);
    }


    public TestCase addTestCase(Integer problemId, @Valid TestCaseDTO testCaseDTO) {
        CodingProblem codingProblem = codingProblemRepo.findById(problemId).orElseThrow();
        TestCase testCase = new TestCase();
        testCase.setCodingProblem(codingProblem);
        testCase.setExpectedOutput(testCaseDTO.getExpectedOutput());
        testCase.setInput(testCaseDTO.getInput());
        return testCaseRepo.save(testCase);
    }

    public void addCertificateCompetition(@Valid CertificateCompetitionDTO certificateCompetitionDTO) {
        CertificateCompetition certificateCompetition = new CertificateCompetition();
        certificateCompetition.setId(certificateCompetitionDTO.getId());
        certificateCompetition.setDurationTime(certificateCompetition.getDurationTime());
        certificateCompetitionRepo.save(certificateCompetition);
    }
}
