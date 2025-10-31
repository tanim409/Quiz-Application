package com.QuizApplication.repo;

import com.QuizApplication.entities.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProgressRepo extends JpaRepository<UserProgress,Integer> {
    UserProgress findByUserId(Integer id);
}
