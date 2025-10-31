package com.QuizApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ProblemSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String language;
    private String code;
    private String category;
    private Double executedTime;
    private Double memoryUsage;

    private String difficulty;
    private LocalDateTime submittedTime;
    private String status;// ACCEPTED, COMPILATION_ERROR..............

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="codingProblem_id")
    @JsonIgnore
    private CodingProblem codingProblem;

    @PrePersist
    public void ovCreated() {
        this.submittedTime = LocalDateTime.now();
    }


}
