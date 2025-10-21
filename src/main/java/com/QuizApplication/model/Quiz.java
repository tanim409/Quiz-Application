package com.QuizApplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String category;

    @ManyToMany
    List<Question> questions;

    @OneToOne(mappedBy = "quiz", cascade = CascadeType.ALL)
    Course course;


}
