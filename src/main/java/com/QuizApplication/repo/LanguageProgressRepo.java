package com.QuizApplication.repo;

import com.QuizApplication.entities.LanguageProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageProgressRepo extends JpaRepository<LanguageProgress,Integer> {
  //  @Query("select lp from LanguageProgress lp where lp.LanguageProgress.user.id =: userId AND lp.language
  //  =:language")
   @Query("SELECT lp FROM LanguageProgress lp WHERE lp.language = :language AND lp.userProgress.user.id = :userId")
    LanguageProgress findByLanguageAndUserId(@Param("userId") Integer userId, @Param("language") String language);
}
