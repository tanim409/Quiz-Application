package com.QuizApplication.service;

import com.QuizApplication.DTO.*;

import com.QuizApplication.model.*;
import com.QuizApplication.model.Module;
import com.QuizApplication.repo.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Lesson> getAllLessonByCourse(Integer courseId) {
        return lessonRepo.findAllByCourseId(courseId);
    }
    public List<Lesson> getAllLessonByModule(Integer moduleId) {
        return lessonRepo.findAllByModuleId(moduleId);
    }

    public Tutorial getAllTutorial(Integer courseId, Integer moduleId, Integer lessonId) {
        return tutorialRepo.findById(lessonId).orElse(null);
    }

    public Section getAllSectionByCourseId(Integer courseId, Integer tutorialId) {
        return sectionRepo.findById(tutorialId).orElse(null);
    }

    public Example getAllExampleByTutorialId(Integer courseId, Integer tutorialId) {
        return exampleRepo.findById(tutorialId).orElse(null);
    }

    public Example getAllExampleBySectionId(Integer courseId, Integer tutorialId, Integer sectionId) {
            return exampleRepo.findById(sectionId).orElse(null);
    }

    public Lesson updateLesson(Integer courseId, Integer moduleId, Integer lessonId,LessonDTORequest lessonDTORequest) {
        Lesson lesson = lessonRepo.findById(lessonId).orElse(null);
        lesson.setId(lessonDTORequest.getId());
        lesson.setTitle(lessonDTORequest.getTitle());
        lesson.setDescription(lessonDTORequest.getDescription());
        return lessonRepo.save(lesson);
    }

    public Tutorial updateTutorial(Integer tutorialId, TutorialDTO tutorialDTO) {
        Tutorial tutorial = tutorialRepo.findById(tutorialId).orElse(null);
        tutorial.setId(tutorialDTO.getId());
        tutorial.setVideoUrl(tutorialDTO.getVideoUrl());
        return tutorialRepo.save(tutorial);
    }

    public Section updateSection(Integer sectionId, @Valid SectionDTO sectionDTO) {

        Section section = sectionRepo.findById(sectionId).orElse(null);
        section.setId(sectionDTO.getId());
        section.setTitle(sectionDTO.getTitle());
        section.setContent(sectionDTO.getContent());
        section.setImageUrl(sectionDTO.getImageUrl());

        return sectionRepo.save(section);
    }

    public Example updateExample(Integer exampleId, ExampleDTO exampleDTO) {
        Example example = exampleRepo.findById(exampleId).orElse(null);
        example.setId(exampleDTO.getId());
        example.setCode(exampleDTO.getCode());
        example.setOutput(exampleDTO.getOutput());
        example.setLanguage(exampleDTO.getLanguage());
        example.setExplanation(exampleDTO.getExplanation());
        return exampleRepo.save(example);
    }

    public void deleteLesson(Integer lessonId) {
        lessonRepo.deleteById(lessonId);
    }

    public void deleteTutorial(Integer tutorialId) {
        tutorialRepo.deleteById(tutorialId);
    }

    public void deleteSection(Integer sectionId) {
        sectionRepo.deleteById(sectionId);
    }

    public void deleteExample(Integer exampleId) {
        exampleRepo.deleteById(exampleId);
    }
}
