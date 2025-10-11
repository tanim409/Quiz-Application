package com.QuizApplication.service;

import com.QuizApplication.DTO.ModuleDTORequest;
import com.QuizApplication.model.Course;
import com.QuizApplication.model.Module;
import com.QuizApplication.repo.CourseRepo;
import com.QuizApplication.repo.ModuleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
