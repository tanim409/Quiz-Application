package com.QuizApplication.repo;

import com.QuizApplication.entities.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {
    List<Enrollment> findAllById(Integer courseId);
}
