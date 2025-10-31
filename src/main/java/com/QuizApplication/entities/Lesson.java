package com.QuizApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    Tutorial tutorial;

    @ManyToOne
    @JoinColumn(name = "module_id")
    @JsonIgnore
    Module module;

    @ManyToOne
    @JoinColumn(name="courseId")
            @JsonIgnore
    Course course;

}
