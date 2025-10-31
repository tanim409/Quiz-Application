package com.QuizApplication.DTO.ExternalAPI;

import lombok.Data;

@Data
public class JdoodleRequest {

     private String clientId;
     private String clientSecret;
     private String script;
     private String language;
     private String versionIdx;
     private String stdin;

}
