package com.QuizApplication.repo;

import com.QuizApplication.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepo extends JpaRepository<Tutorial,Integer> {
}
