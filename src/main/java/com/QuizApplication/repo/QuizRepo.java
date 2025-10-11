package com.QuizApplication.repo;


import com.QuizApplication.DTO.QuizResponse;
import com.QuizApplication.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {

    List<Quiz> findByCategory(String category);
}
