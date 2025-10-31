package com.QuizApplication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String courseName;
    private String title;
    private String description;
    private String price;
    private String backImageUrl;
    private String IntroVdoUrl;


    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Module> modules;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Enrollment> enrollmentsByCourse;

    @OneToOne
    @JoinColumn(name = "quiz_id")
    Quiz quiz;


}
