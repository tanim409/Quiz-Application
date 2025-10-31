package com.QuizApplication.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class UserProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer totalProblemSolved;
    private Integer points;


    @OneToMany(mappedBy = "userProgress", cascade = CascadeType.ALL)
    List<SkillProgress> skills;

    @OneToMany(mappedBy = "userProgress", cascade = CascadeType.ALL)
    List<LanguageProgress> languageProgressList;


    @OneToOne
    @JoinColumn(name="user_id")
    private User user;


}

