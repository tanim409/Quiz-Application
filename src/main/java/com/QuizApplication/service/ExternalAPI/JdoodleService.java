package com.QuizApplication.service.ExternalAPI;

import com.QuizApplication.DTO.Course.CodeExecutionDTO;
import com.QuizApplication.DTO.Course.CodeSubmissionDTO;
import com.QuizApplication.DTO.Course.TestCaseResultDTO;
import com.QuizApplication.DTO.ExternalAPI.JdoodleRequest;
import com.QuizApplication.DTO.ExternalAPI.JdoodleResponse;
import com.QuizApplication.entities.CodingProblem;
import com.QuizApplication.entities.ProblemSubmission;
import com.QuizApplication.entities.TestCase;
import com.QuizApplication.repo.CodingProblemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class JdoodleService {

    @Value("${jdoodle.client.id}")
    private String clientId;
    @Value("${jdoodle.client.secret}")
    private String clientSecret;
    @Value("${jdoodle.api.url}")
    private String jdoodleUrl;

    @Autowired
    CodingProblemRepo codingProblemRepo;

    private final RestTemplate restTemplate = new RestTemplate();

    public CodeExecutionDTO executeCode(CodeSubmissionDTO codeSubmission) {
        CodingProblem codingProblem = codingProblemRepo.findById(codeSubmission.getProblemId()).orElse(null);
        JdoodleRequest request = createRequest(codeSubmission, codingProblem);
        JdoodleResponse response = createResponse(request, codingProblem);
        return parseJdoodle(response,codingProblem);
    }

    private CodeExecutionDTO parseJdoodle(JdoodleResponse response, CodingProblem codingProblem) {

        List<TestCaseResultDTO> testCaseDTO = new ArrayList<>();
        TestCaseResultDTO testCaseDTO1 = new TestCaseResultDTO();
        TestCase testCase = codingProblem.getTestCase().get(0);
        testCaseDTO1.setActualOutput(response.getOutPut());
        testCaseDTO1.setExpectedOutput(testCase.getExpectedOutput());
        testCaseDTO1.setPassed(response.getOutPut()!=null && response.getOutPut().trim().equals(testCase.getExpectedOutput()));
        testCaseDTO1.setError(response.getError());
        testCaseDTO1.setStatusCode(response.getStatusCode());
        testCaseDTO1.setTimeLimit(response.getCpuTime());
        testCaseDTO1.setMemoryLimit(response.getMemory());
        testCaseDTO1.setStatus(response.getError() != null ? "Run Time Error" : "Success");

        testCaseDTO.add(testCaseDTO1);
        return new CodeExecutionDTO(testCaseDTO);
    }

    private JdoodleResponse createResponse(JdoodleRequest request, CodingProblem codingProblem) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<JdoodleRequest> httpEntity = new HttpEntity<>(request, httpHeaders);

        return restTemplate.postForObject(
                jdoodleUrl,
                httpEntity,
                JdoodleResponse.class

        );
    }

    private JdoodleRequest createRequest(CodeSubmissionDTO codeSubmission, CodingProblem codingProblem) {

        JdoodleRequest request = new JdoodleRequest();
        request.setClientId(clientId);
        request.setClientSecret(clientSecret);
        request.setScript(codeSubmission.getCode());
        request.setLanguage(getJdoodleLanguage(codingProblem.getLanguage()));
        request.setVersionIdx("0");

        if (!codingProblem.getTestCase().isEmpty()) {
            request.setStdin(codingProblem.getTestCase().get(0).getInput());
        }

        return request;
    }

    private String getJdoodleLanguage(String language) {
         return switch (language.toUpperCase()) {
                case "JAVA" -> "java";
                case "KOTLIN" -> "kotlin";
                case "C#" -> "c#";
                case "JAVASCRIPT" -> "javascript";
                default -> "java";

        };
    }


}
