package com.QuizApplication.repo;


import com.QuizApplication.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {

    Quiz findByCategory(String category);

}
