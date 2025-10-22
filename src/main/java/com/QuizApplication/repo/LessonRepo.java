package com.QuizApplication.repo;

import com.QuizApplication.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepo extends JpaRepository<Lesson,Integer> {
    List<Lesson> findAllByCourseId(Integer courseId);
    List<Lesson> findAllByModuleId(Integer courseId);
}
