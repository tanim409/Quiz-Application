package com.QuizApplication.service;

import com.QuizApplication.DTO.CourseDTORequest;
import com.QuizApplication.model.Course;
import com.QuizApplication.model.Enrollment;
import com.QuizApplication.model.User;
import com.QuizApplication.repo.CourseRepo;
import com.QuizApplication.repo.EnrollmentRepo;
import com.QuizApplication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepo courserepo;
    @Autowired
    EnrollmentRepo enrollmentRepo;
    @Autowired
    UserRepo userRepo;

    public Course addCourse(CourseDTORequest courseDTORequest) {

        Course course = new Course();
        course.setCourseName(courseDTORequest.getCourseName());
        course.setTitle(courseDTORequest.getTitle());
        course.setDescription(courseDTORequest.getDescription());
        course.setPrice(courseDTORequest.getPrice());
        course.setBackImageUrl(courseDTORequest.getBackImageUrl());
        course.setIntroVdoUrl(courseDTORequest.getIntroVdoUrl());
        return courserepo.save(course);
    }

    public void DeleteCourse(Integer id) {
        courserepo.deleteById(id);
    }

    public Course updateCourseById(Integer id, CourseDTORequest courseDTORequest) {
        Course course = courserepo.findById(id).orElseThrow(()->new RuntimeException("course not found"));
        course.setTitle(courseDTORequest.getTitle());
        course.setDescription(courseDTORequest.getDescription());
        course.setPrice(courseDTORequest.getPrice());
        course.setBackImageUrl(courseDTORequest.getBackImageUrl());
        course.setIntroVdoUrl(courseDTORequest.getIntroVdoUrl());

        return courserepo.save(course);
    }

    public List<Course> getAllCourses() {
        return courserepo.findAll();
    }


    public Enrollment addStudent(Integer courseId, String userName) {
        Course course = courserepo.findById(courseId).orElseThrow(()->new RuntimeException("course not found"));
        User user = userRepo.findByUsername(userName);
        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setUser(user);
        return enrollmentRepo.save(enrollment);
    }
}
