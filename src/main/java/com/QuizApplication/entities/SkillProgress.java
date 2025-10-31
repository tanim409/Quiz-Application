package com.QuizApplication.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SkillProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    private String category;
    private Integer totalProblemSolved;
    private Integer totalProblems;

    @ManyToOne  // ← Remove cascade
    @JoinColumn(name="userProgress_id")
    private UserProgress userProgress;
}
