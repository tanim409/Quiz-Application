package com.QuizApplication.DTO.Course;

import com.QuizApplication.entities.Enrollment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentDTO {

    private Integer id;

    public static EnrollmentDTO enrollmentDTO(Enrollment enrollment) {
        return new EnrollmentDTO(enrollment.getId());
    }
}
