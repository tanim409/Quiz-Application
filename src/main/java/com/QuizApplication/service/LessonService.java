package com.QuizApplication.service;

import com.QuizApplication.DTO.*;

import com.QuizApplication.model.*;
import com.QuizApplication.model.Module;
import com.QuizApplication.repo.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    @Autowired
    LessonRepo lessonRepo;
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    ModuleRepo moduleRepo;
    @Autowired
    TutorialRepo tutorialRepo;
    @Autowired
    SectionRepo sectionRepo;
    @Autowired
    ExampleRepo exampleRepo;


    public Lesson addLesson(Integer courseId, Integer moduleId, @Valid LessonDTORequest lessonDTORequest) {
        Course course = courseRepo.findById(courseId).orElse(null);
        Module module = moduleRepo.findById(moduleId).orElse(null);
        Lesson lesson = new Lesson();
        lesson.setTitle(lessonDTORequest.getTitle());
        lesson.setDescription(lessonDTORequest.getDescription());
        lesson.setCourse(course);
        lesson.setModule(module);
        return lessonRepo.save(lesson);
    }

    public Tutorial addTutorial(Integer courseId, Integer moduleId, Integer lessonId, TutorialDTO tutorialRequest) {
        Course course = courseRepo.findById(courseId).orElse(null);
        Module module = moduleRepo.findById(moduleId).orElse(null);
        Lesson lesson = lessonRepo.findById(lessonId).orElse(null);

        Tutorial tutorial = new Tutorial();
        tutorial.setId(tutorialRequest.getId());
        tutorial.setVideoUrl(tutorialRequest.getVideoUrl());
        tutorial.setLesson(lesson);
        return tutorialRepo.save(tutorial);


    }

    public Section addSection(@Valid SectionDTO sectionDTORequest, Integer tutorialId) {
        Tutorial tutorial = tutorialRepo.findById(tutorialId).orElse(null);

        Section section = new Section();
        section.setId(sectionDTORequest.getId());
        section.setTitle(sectionDTORequest.getTitle());
        section.setContent(sectionDTORequest.getContent());
        section.setImageUrl(sectionDTORequest.getImageUrl());
        section.setTutorial(tutorial);
        return sectionRepo.save(section);
    }

    public Example addExample(ExampleDTO exampleDTO,Integer tutorialId,Integer sectionId) {
      Tutorial tutorial = tutorialRepo.findById(tutorialId).orElse(null);
      Section section = sectionRepo.findById(sectionId).orElse(null);
      Example example = new Example();
      example.setId(exampleDTO.getId());
      example.setCode(exampleDTO.getCode());
      example.setOutput(exampleDTO.getOutput());
      example.setLanguage(exampleDTO.getLanguage());
      example.setExplanation(exampleDTO.getExplanation());
      example.setTutorial(tutorial);
      example.setSection(section);

      return exampleRepo.save(example);
    }
}
