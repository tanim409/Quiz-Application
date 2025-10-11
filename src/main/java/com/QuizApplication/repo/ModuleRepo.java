package com.QuizApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.QuizApplication.model.Module;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepo extends JpaRepository<Module, Integer> {
}
