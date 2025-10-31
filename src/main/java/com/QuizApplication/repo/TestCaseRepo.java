package com.QuizApplication.repo;

import com.QuizApplication.entities.TestCase;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseRepo extends JpaRepository<TestCase, Integer> {
}
