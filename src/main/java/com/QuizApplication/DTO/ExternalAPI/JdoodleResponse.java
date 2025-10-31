package com.QuizApplication.DTO.ExternalAPI;

import lombok.Data;

@Data
public class JdoodleResponse {

    private Double cpuTime;
    private Double memory;
    private String outPut;
    private String error;
    private String statusCode;


}
