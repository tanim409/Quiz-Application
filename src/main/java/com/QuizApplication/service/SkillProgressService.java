package com.QuizApplication.service;

import com.QuizApplication.entities.Difficulty;
import com.QuizApplication.entities.SkillProgress;
import com.QuizApplication.entities.UserProgress;
import com.QuizApplication.repo.CodingProblemRepo;
import com.QuizApplication.repo.SkillProgressRepo;
import com.QuizApplication.repo.SubmissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SkillProgressService {

    @Autowired
    private SkillProgressRepo skillProgressRepo;

    @Autowired
    SubmissionRepo submissionRepo;

    @Autowired
    CodingProblemRepo codingProblemRepo;

    public SkillProgress addSkillProgress(UserProgress userProgress, String category) {
        Integer userId = userProgress.getUser().getId();
        SkillProgress skillProgress = skillProgressRepo.findByUserIdAndCategory(userId, category);
        if(skillProgress != null) {
            skillProgress.setUserProgress(userProgress);
            Integer problemSolved = submissionRepo.countSolvedProblemByUserAndCategory(userId,category);
            skillProgress.setTotalProblemSolved(problemSolved);
            Integer totalProblem = codingProblemRepo.countByCategory(category);
            skillProgress.setTotalProblems(totalProblem);
            skillProgress.setCategory(category);

            if (category.equals("Array") || category.equals("String") || category.equals("Integer")) {
                skillProgress.setDifficulty(Difficulty.EASY);
            }
            if (category.equals("set") || category.equals("Tree") || category.equals("Graph")) {
                skillProgress.setDifficulty(Difficulty.MEDIUM);
            }
            if (category.equals("DP") || category.equals("Recursion") || category.equals("Matrix")) {
                skillProgress.setDifficulty(Difficulty.HARD);
            }
        }else{
            createNewSkillProgress(userProgress,category);
        }
        return skillProgressRepo.save(skillProgress);
    }


    private void createNewSkillProgress(UserProgress userProgress, String category) {
        SkillProgress skillProgress = new SkillProgress();
        Integer userId = userProgress.getUser().getId();

        skillProgress.setCategory(category);
        skillProgress.setUserProgress(userProgress);
        Integer totalProblem = codingProblemRepo.countByCategory(category);
        skillProgress.setTotalProblems(totalProblem);
        if (category.equals("Array") || category.equals("String") || category.equals("Integer")) {
            skillProgress.setDifficulty(Difficulty.EASY);
        }
        if (category.equals("set") || category.equals("Tree") || category.equals("Graph")) {
            skillProgress.setDifficulty(Difficulty.MEDIUM);
        }
        if (category.equals("DP") || category.equals("Recursion") || category.equals("Matrix")) {
            skillProgress.setDifficulty(Difficulty.HARD);
        }
        skillProgress.setTotalProblems(0);

        skillProgressRepo.save(skillProgress);
    }

}
