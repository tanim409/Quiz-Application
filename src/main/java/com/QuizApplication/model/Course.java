package com.QuizApplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
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
    List<Module> modules = new ArrayList<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    List<Enrollment> enrollmentsByCourse;



}
