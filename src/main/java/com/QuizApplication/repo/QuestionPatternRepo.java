package com.QuizApplication.repo;

import com.QuizApplication.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionPatternRepo extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);
}
