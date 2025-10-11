package com.QuizApplication.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Module {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
 private String title;


 @ManyToOne
 @JoinColumn(name = "course_id")
 private Course course;

 @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
 List<Lesson> lessons = new ArrayList<Lesson>();


}
