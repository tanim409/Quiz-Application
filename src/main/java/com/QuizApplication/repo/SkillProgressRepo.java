package com.QuizApplication.repo;

import com.QuizApplication.entities.SkillProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface SkillProgressRepo extends JpaRepository<SkillProgress,Integer> {
    @Query("SELECT sp FROM SkillProgress sp WHERE sp.userProgress.user.id = :userId AND sp.category = :category")
    SkillProgress findByUserIdAndCategory(@Param("userId") Integer userId,
                                          @Param("category") String category);
}
