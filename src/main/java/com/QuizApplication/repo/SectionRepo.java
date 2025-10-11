package com.QuizApplication.repo;

import com.QuizApplication.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface SectionRepo extends JpaRepository<Section,Integer> {
}
