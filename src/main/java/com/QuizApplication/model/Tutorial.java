package com.QuizApplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Tutorial {
    @Id
    private Integer id;
    private String videoUrl;
    @OneToMany(mappedBy = "tutorial",cascade = CascadeType.ALL)
    List<Section> Section;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_id")
    Lesson lesson;
    @OneToMany(mappedBy = "tutorial",cascade = CascadeType.ALL)
    List<Example> example;
}
