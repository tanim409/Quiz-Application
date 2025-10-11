package com.QuizApplication.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Lesson {
    @Id
    private Integer id;

    String title;
    @Lob
    @Column(columnDefinition = "LONGTEXT") // 4gb
    String description;

    @OneToOne(mappedBy = "lesson",cascade = CascadeType.ALL)
    Tutorial tutorial;
    @OneToOne
    @JoinColumn(name = "quiz_id")
    Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "module_id")
    Module module;

    @ManyToOne
    @JoinColumn(name="courseId")
    Course course;

}
