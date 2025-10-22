package com.QuizApplication.service;

import com.QuizApplication.DTO.ModuleDTORequest;
import com.QuizApplication.model.Course;
import com.QuizApplication.model.Module;
import com.QuizApplication.repo.CourseRepo;
import com.QuizApplication.repo.ModuleRepo;
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

    public Module addModule(Integer courseId,ModuleDTORequest moduleDTORequest) {

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

        Module module = modulerepo.findById(moduleId).orElse(null);
        module.setTitle(moduleDTORequest.getTitle());
        module.setCourse(courserepo.findById(courseId).orElse(null));


        return modulerepo.save(module);
    }

    public void deleteModule(Integer moduleId) {
            modulerepo.deleteById(moduleId);
    }
}
