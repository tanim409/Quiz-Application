package com.QuizApplication.repo;

import com.QuizApplication.entities.ProblemSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepo extends JpaRepository<ProblemSubmission,Integer> {

    Integer countByLanguage(String language);

    Integer countByUserId(Integer id);

    @Query("select count(distinct s.id) from ProblemSubmission s where s.user.id =:userId AND s.language =:language")
    Integer countSolvedProblemByUserAndLanguage(@Param("userId") Integer userId, @Param("language") String language);

    @Query("select count(distinct s.id) from ProblemSubmission s where s.user.id =:userId AND s.category =:category")
    Integer countSolvedProblemByUserAndCategory(@Param("userId") Integer userId, @Param("category") String category);
}
