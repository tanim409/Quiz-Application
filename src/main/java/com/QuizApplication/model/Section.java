package com.QuizApplication.model;

import jakarta.persistence.*;
import jdk.jfr.ContentType;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Section {
    @Id
    private Integer id;

    String title;
    @Lob
    @Column(columnDefinition="LONGTEXT")   // 4GB
    String content;
    String imageUrl;

    @OneToMany(mappedBy = "section")
    List<Example> examples;

    @ManyToOne
    @JoinColumn(name = "tutorial_id")
    Tutorial tutorial;


}
