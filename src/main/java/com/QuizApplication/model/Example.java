package com.QuizApplication.model;

import com.QuizApplication.DTO.TutorialDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Example {
    @Id
    private Integer id;
    String code;
    String output;
    String language;
    String explanation;
    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonIgnore
    Section section;
    @ManyToOne
    @JoinColumn(name = "tutorial_id")
    @JsonIgnore
    Tutorial tutorial;
}
