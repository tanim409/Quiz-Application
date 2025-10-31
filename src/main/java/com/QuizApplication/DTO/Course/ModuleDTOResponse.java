package com.QuizApplication.DTO.Course;
import com.QuizApplication.entities.Module;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModuleDTOResponse {
    private Integer id;
    private String title;

    public static ModuleDTOResponse moduleResponse(Module saveModule) {
            return new ModuleDTOResponse(saveModule.getId(), saveModule.getTitle());
    }
}
