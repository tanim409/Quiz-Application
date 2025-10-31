package com.QuizApplication.service;

import com.QuizApplication.DTO.Course.CodingProblemDTO;
import com.QuizApplication.DTO.Course.ModuleDTORequest;
import com.QuizApplication.DTO.Course.TestCaseDTO;
import com.QuizApplication.entities.CodingProblem;
import com.QuizApplication.entities.Course;
import com.QuizApplication.entities.Module;
import com.QuizApplication.entities.TestCase;
import com.QuizApplication.repo.CodingProblemRepo;
import com.QuizApplication.repo.CourseRepo;
import com.QuizApplication.repo.ModuleRepo;
import com.QuizApplication.repo.TestCaseRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {

    @Autowired
    ModuleRepo modulerepo;
    @Autowired
    CourseRepo courserepo;
    @Autowired
    CodingProblemRepo codingProblemRepo;
    @Autowired
    TestCaseRepo  testcaserepo;

    public Module addModule(Integer courseId, ModuleDTORequest moduleDTORequest) {

        Course course = courserepo.findById(courseId).orElse(null);

        Module module = new Module();
        module.setTitle(moduleDTORequest.getTitle());
        module.setCourse(course);
        return modulerepo.save(module);
    }

    public List<Module> getAllModule(Integer courseId) {
        return modulerepo.findAllById(courseId);
    }

    public Module updateModule(Integer courseId, Integer moduleId, ModuleDTORequest moduleDTORequest) {

        Module module = modulerepo.findById(moduleId).orElseThrow(NullPointerException::new);
        module.setTitle(moduleDTORequest.getTitle());
        module.setCourse(courserepo.findById(courseId).orElse(null));


        return modulerepo.save(module);
    }

    public void deleteModule(Integer moduleId) {
        modulerepo.deleteById(moduleId);
    }

    public CodingProblem addCodingProblem(Integer moduleId, @Valid CodingProblemDTO codingProblemForCourseDTO) {
        Module module = modulerepo.findById(moduleId).orElse(null);
        CodingProblem task = new CodingProblem();
        task.setTitle(codingProblemForCourseDTO.getTitle());
        task.setDescription(codingProblemForCourseDTO.getDescription());
        task.setLanguage(codingProblemForCourseDTO.getLanguage());
        task.setDifficulty(codingProblemForCourseDTO.getDifficulty());
        task.setTimeLimit(codingProblemForCourseDTO.getTimeLimit());
        task.setMemoryLimit(codingProblemForCourseDTO.getMemoryLimit());
        task.setModule(module);
        return codingProblemRepo.save(task);
    }

    public TestCase addTestCase(Integer moduleId, Integer problemId, @Valid TestCaseDTO testCaseDTO) {
        CodingProblem problemForCourse = codingProblemRepo.findById(problemId).orElse(null);
        TestCase testCase = new TestCase();
        testCase.setId(testCaseDTO.getId());
        testCase.setInput(testCaseDTO.getInput());
        testCase.setExpectedOutput(testCaseDTO.getExpectedOutput());
        testCase.setCodingProblem(problemForCourse);
        return testcaserepo.save(testCase);
    }
}
