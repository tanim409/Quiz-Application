package com.QuizApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
public class CodingProblem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ← ADD THIS
    private Integer id;

    @Lob
    private String title;
    @Lob
    private String description;
    private String language;
    private String category;

    @Enumerated(EnumType.STRING)  // ← ADD THIS for safety
    private Difficulty difficulty;

    private Integer timeLimit;
    private Integer memoryLimit;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "codingProblem", cascade = CascadeType.ALL)  // ← ADD CASCADE
    List<TestCase> testCase;

    @OneToMany(mappedBy = "codingProblem", cascade = CascadeType.ALL)  // ← ADD CASCADE
    List<ProblemSubmission> problemSubmission;

    @ManyToOne
    @JoinColumn(name = "certificate_Competition_id")
    CertificateCompetition certificateCompetition;

    @ManyToOne
    @JoinColumn(name = "module_id")
    @JsonIgnore
    Module module;



    @PrePersist
    public void onCreate() {
        if(creationDate == null) {
            creationDate = LocalDateTime.now();
            updateDate = LocalDateTime.now();
        }
    }

    @PreUpdate
    public void onUpdate() {
        updateDate = LocalDateTime.now();
    }


}
