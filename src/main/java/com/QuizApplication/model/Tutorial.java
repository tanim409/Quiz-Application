package com.QuizApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    List<Section> Section;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_id")
    Lesson lesson;


}
