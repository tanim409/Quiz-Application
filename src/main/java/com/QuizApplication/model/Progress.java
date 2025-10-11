package com.QuizApplication.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Progress {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;


 @ManyToOne
 private Enrollment enrollment;



 @ManyToOne
 Lesson lesson;

 Boolean complete;

}
