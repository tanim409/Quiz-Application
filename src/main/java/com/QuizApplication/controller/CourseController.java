package com.QuizApplication.controller;


import com.QuizApplication.DTO.*;
import com.QuizApplication.model.*;
import com.QuizApplication.model.Module;
import com.QuizApplication.service.CourseService;
import com.QuizApplication.service.LessonService;
import com.QuizApplication.service.ModuleService;
import jakarta.validation.Valid;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    ModuleService moduleService;

    @Autowired
    LessonService lessonService;

    @PostMapping("/AddCourse")
    public CourseDTOResponse addCourse(@Valid @RequestBody CourseDTORequest courseDTORequest) {
        Course saveCourse = courseService.addCourse(courseDTORequest);
        return CourseDTOResponse.courseResponse(saveCourse);
    }

    @DeleteMapping("/{id}")
    public String DeleteCourse(@PathVariable Integer id) {

        courseService.DeleteCourse(id);
        return "Course Deleted  Successfully";
    }

    @PutMapping("/up/{id}")
    public ResponseEntity<CourseDTOResponse> updateCourseById(@PathVariable Integer id,
                                                              @Valid @RequestBody CourseDTORequest courseDTORequest) {
        Course course = courseService.updateCourseById(id, courseDTORequest);

        return ResponseEntity.ok(CourseDTOResponse.courseResponse(course));
    }

    @GetMapping("/getCourse")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    // Model
    @PostMapping("/{courseId}/Module")
    public ModuleDTOResponse addModule(@PathVariable Integer courseId,
                                       @Valid @RequestBody ModuleDTORequest moduleDTORequest) {
        Module saveModule = moduleService.addModule(courseId, moduleDTORequest);
        return ModuleDTOResponse.moduleResponse(saveModule);
    }

    @PostMapping("/{courseId}/{moduleId}/lesson")
    public LessonDTOResponse addLesson(@PathVariable Integer courseId,
                                       @PathVariable Integer moduleId,
                                       @Valid @RequestBody LessonDTORequest lessonDTORequest) {
        Lesson lesson = lessonService.addLesson(courseId, moduleId, lessonDTORequest);
        return LessonDTOResponse.lessonResponse(lesson);
    }

    @PostMapping("/{courseId}/{moduleId}/{lessonId}/tutorial")
    public TutorialDTO addTutorial(@PathVariable Integer courseId,
                                   @PathVariable Integer moduleId,
                                   @PathVariable Integer lessonId,
                                   @Valid @RequestBody TutorialDTO tutorialRequest) {
        Tutorial tutorial = lessonService.addTutorial(courseId, moduleId, lessonId, tutorialRequest);
        return TutorialDTO.tutorialResponse(tutorial);
    }

    @PostMapping("section/{tutorialId}")
    public SectionDTO addSection(@Valid @RequestBody SectionDTO sectionDTORequest, @PathVariable Integer tutorialId) {
        Section section = lessonService.addSection(sectionDTORequest, tutorialId);
        return SectionDTO.sectionResponse(section);
    }

    @PostMapping("example/{tutorialId}/{sectionId}")
    public ExampleDTO addExample(@Valid @RequestBody ExampleDTO exampleDTO,
                                 @PathVariable Integer tutorialId,
                                 @PathVariable Integer sectionId) {
        Example example = lessonService.addExample(exampleDTO,tutorialId, sectionId);
        return ExampleDTO.examResponse(example);
    }
    @PostMapping("/enrollment/{courseId}/{userName}")
    public EnrollmentDTO addStudent(@PathVariable Integer courseId,@PathVariable String userName) {
        Enrollment enrollment = courseService.addStudent(courseId,userName);
        return EnrollmentDTO.enrollmentDTO(enrollment);
    }
}
