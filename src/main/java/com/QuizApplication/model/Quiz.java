package com.QuizApplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Entity
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String category;
    String subCategory;

    @ManyToMany
    List<Question> questions;
    @OneToOne
    @JoinColumn(name="lesson_id")
    Lesson lesson;


}
