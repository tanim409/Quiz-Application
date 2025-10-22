package com.QuizApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizApplication.model.Module;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepo extends JpaRepository<Module, Integer> {
    List<Module> findAllById(Integer courseId);
}
