package com.QuizApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    private String input;
    @Lob
    private String expectedOutput;



    @ManyToOne
    @JoinColumn(name="codingProblem_id")
    private CodingProblem codingProblem;



}
