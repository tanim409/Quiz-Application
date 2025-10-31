package com.QuizApplication.repo;

import com.QuizApplication.entities.CodingProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodingProblemRepo extends JpaRepository<CodingProblem, Integer> {
    Integer countByCategory(String category);

    Integer countByLanguage(String language);
}
