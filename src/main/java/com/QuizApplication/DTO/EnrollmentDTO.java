package com.QuizApplication.DTO;

import com.QuizApplication.model.Course;
import com.QuizApplication.model.Enrollment;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public static EnrollmentDTO enrollmentDTO(Enrollment enrollment) {
        return new EnrollmentDTO(enrollment.getId());
    }
}
