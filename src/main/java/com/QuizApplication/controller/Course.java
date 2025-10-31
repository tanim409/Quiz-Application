package com.QuizApplication.controller;


import com.QuizApplication.DTO.Course.*;
import com.QuizApplication.DTO.TasksForCertificate.CertificateCompetitionDTO;
import com.QuizApplication.entities.*;
import com.QuizApplication.entities.Module;

import com.QuizApplication.entities.Quiz;
import com.QuizApplication.service.CertificateService;
import com.QuizApplication.service.CourseService;
import com.QuizApplication.service.LessonService;
import com.QuizApplication.service.ModuleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class Course {

    @Autowired
    CourseService courseService;

    @Autowired
    ModuleService moduleService;

    @Autowired
    LessonService lessonService;

    @Autowired
    CertificateService certificateService;

    @PostMapping("/AddCourse")
    public CourseDTOResponse addCourse(@Valid @RequestBody CourseDTORequest courseDTORequest) {
        com.QuizApplication.entities.Course saveCourse = courseService.addCourse(courseDTORequest);
        return CourseDTOResponse.courseResponse(saveCourse);
    }

    @GetMapping("/getCourse")
    public List<com.QuizApplication.entities.Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @PutMapping("/update/{id}")
    public CourseDTOResponse updateCourseById(@PathVariable Integer id,
                                              @Valid @RequestBody CourseDTORequest courseDTORequest) {
        com.QuizApplication.entities.Course course = courseService.updateCourseById(id, courseDTORequest);
        return CourseDTOResponse.courseResponse(course);
    }

    @DeleteMapping("/{id}")
    public String DeleteCourse(@PathVariable Integer id) {
        courseService.DeleteCourse(id);
        return "Course Deleted  Successfully";
    }






    // Model.................
    @PostMapping("/{courseId}/Module")
    public ModuleDTOResponse addModule(@PathVariable Integer courseId,
                                       @Valid @RequestBody ModuleDTORequest moduleDTORequest) {
        Module saveModule = moduleService.addModule(courseId, moduleDTORequest);
        return ModuleDTOResponse.moduleResponse(saveModule);
    }
    @PostMapping("/{courseId}/{moduleId}/addProblem")
    public CodingProblemDTO addCodingProblem(@PathVariable Integer courseId,
                                             @PathVariable Integer moduleId,
                                             @Valid @RequestBody CodingProblemDTO codingProblemForCourseDTO) {

        CodingProblem problemForCourse = moduleService.addCodingProblem(moduleId,codingProblemForCourseDTO);
        return CodingProblemDTO.codingProblemForCourse(problemForCourse);
    }

    @PostMapping("/{courseId}/{moduleId}/{problemId}/addTestCase")
    public TestCaseDTO addTestCase(@PathVariable Integer courseId,
                                   @PathVariable Integer moduleId,
                                   @PathVariable Integer problemId,
                                   @Valid @RequestBody TestCaseDTO testCaseDTO) {
        TestCase testCase = moduleService.addTestCase(moduleId,problemId,testCaseDTO);
        return TestCaseDTO.testcasedto(testCase);
    }

    @GetMapping("/allModule/{course_id}")
    public List<Module> getAllModule(@PathVariable Integer course_id) {
        return moduleService.getAllModule(course_id);
    }

    @PutMapping("/update/{courseId}/{moduleId}")
    public ModuleDTOResponse updateModule(@PathVariable Integer courseId,
                                          @PathVariable Integer moduleId,
                                          @Valid @RequestBody ModuleDTORequest moduleDTORequest) {
        Module module = moduleService.updateModule(courseId, moduleId, moduleDTORequest);
        return ModuleDTOResponse.moduleResponse(module);
    }
    @DeleteMapping("/delete/module/{courseId}/{moduleId}")
    public String deleteModule(@PathVariable Integer courseId, @PathVariable Integer moduleId) {
        moduleService.deleteModule(moduleId);
        return "Module Deleted";
    }


    // add problem for certificate
    @PostMapping("/certificate/addProblem")
    public CodingProblemDTO addCodingProblem(@Valid @RequestBody CodingProblemDTO codingProblemForCourseDTO,
                                             @RequestBody CertificateCompetitionDTO participationForCertificateDTO) {

        CodingProblem problemForCourse = certificateService.addCodingProblem(codingProblemForCourseDTO);
        return CodingProblemDTO.codingProblemForCourse(problemForCourse);
    }

    @PostMapping("/{problemId}/certificate/addTestCase")
    public TestCaseDTO addTestCase(@PathVariable Integer problemId,@Valid @RequestBody TestCaseDTO testCaseDTO,@RequestBody CertificateCompetitionDTO participationForCertificateDTO) {
        TestCase testCase = certificateService.addTestCase(problemId,testCaseDTO);
        return TestCaseDTO.testcasedto(testCase);
    }

    @PostMapping("/certificate/start")
    public ResponseEntity<String> addCertificateCompetition(@Valid @RequestBody CertificateCompetitionDTO certificateCompetitionDTO) {
        certificateService.addCertificateCompetition(certificateCompetitionDTO);
        return ResponseEntity.ok("Task will be end after --2 Hours");
    }




    // Lesson...............
    @PostMapping("/{courseId}/{moduleId}/lesson")
    public LessonDTOResponse addLesson(@PathVariable Integer courseId,
                                       @PathVariable Integer moduleId,
                                       @Valid @RequestBody LessonDTORequest lessonDTORequest) {
        Lesson lesson = lessonService.addLesson(courseId, moduleId, lessonDTORequest);
        return LessonDTOResponse.lessonResponse(lesson);
    }


    // get all lesson by course Id........
    @GetMapping("lessonByCourse/{courseId}")
    public List<Lesson> getAllLessonsByCourse(@PathVariable Integer courseId) {
        return lessonService.getAllLessonByCourse(courseId);
    }

    // get all lesson by  module Id........
    @GetMapping("lessonByModule/{moduleId}")
    public List<Lesson> getAllLessonsByModule(@PathVariable Integer moduleId) {
        return lessonService.getAllLessonByModule(moduleId);
    }

    @PutMapping("/update/{courseId}/{moduleId}/{lessonId}")
    public LessonDTOResponse updateLesson(@PathVariable Integer courseId, @PathVariable Integer moduleId,
                                          @PathVariable Integer lessonId, @Valid @RequestBody LessonDTORequest lessonDTORequest) {
        Lesson lesson = lessonService.updateLesson(courseId, moduleId, lessonId, lessonDTORequest);
        return LessonDTOResponse.lessonResponse(lesson);
    }


    @DeleteMapping("/delete/lesson/{courseId}/{moduleId}/{lessonId}")
    public String deleteLesson(@PathVariable Integer courseId,
                               @PathVariable Integer moduleId,
                               @PathVariable Integer lessonId) {
        lessonService.deleteLesson(lessonId);
        return "Lesson Deleted";
    }

    // Tutorial...............
    @PostMapping("/{courseId}/{moduleId}/{lessonId}/tutorial")
    public TutorialDTO addTutorial(@PathVariable Integer courseId,
                                   @PathVariable Integer moduleId,
                                   @PathVariable Integer lessonId,
                                   @Valid @RequestBody TutorialDTO tutorialRequest) {
        Tutorial tutorial = lessonService.addTutorial(courseId, moduleId, lessonId, tutorialRequest);
        return TutorialDTO.tutorialResponse(tutorial);
    }

    @GetMapping("/tutorial/{courseId}/{moduleId}/{lessonId}")
    public Tutorial getAllTutorial(@PathVariable Integer courseId, @PathVariable Integer moduleId,
                                   @PathVariable Integer lessonId) {
        return lessonService.getAllTutorial(courseId, moduleId, lessonId);
    }

    @PutMapping("/update/tutorial/{courseId}/{moduleId}/{lessonId}/{tutorialId}")
    public TutorialDTO updateTutorial(@PathVariable Integer courseId,
                                      @PathVariable Integer moduleId,
                                      @PathVariable Integer lessonId,
                                      @PathVariable Integer tutorialId,
                                      @RequestBody TutorialDTO tutorialDTO) {
        Tutorial tutorial = lessonService.updateTutorial(tutorialId, tutorialDTO);
        return TutorialDTO.tutorialResponse(tutorial);
    }

    @DeleteMapping("/delete/tutorial/{courseId}/{moduleId}/{lessonId}/{tutorialId}")
    public String deleteTutorial(@PathVariable Integer courseId, @PathVariable Integer moduleId,
                                 @PathVariable Integer lessonId, @PathVariable Integer tutorialId) {

        lessonService.deleteTutorial(tutorialId);
        return "Tutorial Deleted";
    }

    ///  Section...............
    @PostMapping("section/{tutorialId}")
    public SectionDTO addSection(@Valid @RequestBody SectionDTO sectionDTORequest, @PathVariable Integer tutorialId) {
        Section section = lessonService.addSection(sectionDTORequest, tutorialId);
        return SectionDTO.sectionResponse(section);
    }

    @GetMapping("section/{courseId}/{tutorialId}")
    public Section getAllSectionByCourseId(@PathVariable Integer courseId, @PathVariable Integer tutorialId) {
        return lessonService.getAllSectionByCourseId(courseId, tutorialId);
    }

    @PutMapping("/update/section/{courseId}/{moduleId}/{lessonId}/{tutorialId}/{sectionId}")
    public SectionDTO updateSection(@PathVariable Integer courseId,
                                    @PathVariable Integer moduleId,
                                    @PathVariable Integer lessonId,
                                    @PathVariable Integer tutorialId,
                                    @PathVariable Integer sectionId,
                                    @Valid @RequestBody SectionDTO sectionDTO) {
        Section section = lessonService.updateSection(sectionId, sectionDTO);
        return SectionDTO.sectionResponse(section);
    }
    @DeleteMapping("/delete/section/{courseId}/{moduleId}/{lessonId}/{tutorialId}/{sectionId}")
    public String deleteSection(@PathVariable Integer courseId, @PathVariable Integer moduleId,
                                @PathVariable Integer lessonId, @PathVariable Integer tutorialId,
                                @PathVariable Integer sectionId) {
        lessonService.deleteSection(sectionId);
        return "Section Deleted";
    }

    //Example...................
    @PostMapping("example/{tutorialId}/{sectionId}")
    public ExampleDTO addExample(@Valid @RequestBody ExampleDTO exampleDTO,
                                 @PathVariable Integer tutorialId,
                                 @PathVariable Integer sectionId) {
        Example example = lessonService.addExample(exampleDTO, tutorialId, sectionId);
        return ExampleDTO.examResponse(example);
    }

    @GetMapping("example/{courseId}/{tutorialId}/{sectionId}")
    public Example getAllExampleBySectionId(@PathVariable Integer courseId, @PathVariable Integer tutorialId, @PathVariable Integer sectionId) {
        return lessonService.getAllExampleBySectionId(courseId, tutorialId, sectionId);
    }

    @PutMapping("/update/section/example/{courseId}/{moduleId}/{lessonId}/{tutorialId}/{sectionId}/{exampleId}")
    public ExampleDTO updateExample(@PathVariable Integer courseId, @PathVariable Integer moduleId,
                                    @PathVariable Integer lessonId, @PathVariable Integer tutorialId,
                                    @PathVariable Integer sectionId, @PathVariable Integer exampleId,
                                    @RequestBody ExampleDTO exampleDTO) {

        Example example = lessonService.updateExample(exampleId, exampleDTO);
        return ExampleDTO.examResponse(example);

    }
    @DeleteMapping("/delete/example/{courseId}/{moduleId}/{lessonId}/{tutorialId}/{sectionId}/{exampleId}")
    public String deleteExample(@PathVariable Integer courseId, @PathVariable Integer moduleId,
                                @PathVariable Integer lessonId, @PathVariable Integer tutorialId,
                                @PathVariable Integer sectionId,@PathVariable Integer exampleId) {
        lessonService.deleteExample(exampleId);
        return "Example Deleted";
    }

    //Enrollment...............
    @PostMapping("/enrollment/{courseId}/{userName}")
    public EnrollmentDTO addStudent(@PathVariable Integer courseId, @PathVariable String userName) {
        Enrollment enrollment = courseService.addStudent(courseId, userName);
        return EnrollmentDTO.enrollmentDTO(enrollment);
    }

    @GetMapping("/enrollment/{courseId}")
    public List<Enrollment> getAllEnrollmentByCourseId(@PathVariable Integer courseId) {
        return courseService.getAllEnrollmentByCourseId(courseId);
    }

    @GetMapping("/enrollment")
    public List<Enrollment> getAllEnrollment() {
        return courseService.getAllEnrollment();
    }


    // Add quiz in course
    @PostMapping("/quiz/{course_id}/{category}")
    public QuizDTO quizResponse(@PathVariable Integer course_id, @PathVariable String category) {
        Quiz quiz = courseService.addQuiz(course_id, category);
        return QuizDTO.quizDTO(quiz);
    }

}
