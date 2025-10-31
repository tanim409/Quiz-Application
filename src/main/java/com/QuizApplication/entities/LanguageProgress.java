package com.QuizApplication.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LanguageProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String language;
    private Integer totalProblemsSolved;
    private Integer totalProblems;
    @ManyToOne  // ← Remove cascade
    @JoinColumn(name = "userProgress_id")
    private UserProgress userProgress;
}
