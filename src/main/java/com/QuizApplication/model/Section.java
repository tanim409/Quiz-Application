package com.QuizApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    List<Example> examples;

    @ManyToOne
    @JoinColumn(name = "tutorial_id")
    @JsonIgnore
    Tutorial tutorial;


}
