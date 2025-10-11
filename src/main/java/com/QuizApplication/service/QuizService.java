package com.QuizApplication.service;

import com.QuizApplication.DTO.QuizResponse;
import com.QuizApplication.exception.SecurityException;
import com.QuizApplication.model.Question;
import com.QuizApplication.model.Quiz;
import com.QuizApplication.model.Submit;
import com.QuizApplication.repo.QuestionPatternRepo;
import com.QuizApplication.repo.QuizRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    QuizRepo repo;
    @Autowired
    QuestionPatternRepo questionPatternRepo;

    public ResponseEntity<List<QuizResponse>> quizResponse(String category) {

        if (repo.findByCategory(category).isEmpty()) {
            throw new SecurityException("No Question Found for Category " + category);
        }
        try {
            List<QuizResponse> quizResponse = repo.findByCategory(category).stream()
                    .flatMap(q -> q.getQuestions().stream())
                    .map(this::ConvertToQuizResponse)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(quizResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public QuizResponse ConvertToQuizResponse(Question quizR) {

        return new QuizResponse(
                quizR.getId(),
                quizR.getQuestion(),
                quizR.getOptionA(),
                quizR.getOptionB(),
                quizR.getOptionC(),
                quizR.getOptionD(),
                quizR.getCategory());

    }

    public ResponseEntity<String> insertQuiz(String category) {

        List<Question> questions = questionPatternRepo.findByCategory(category);

        if (questions.isEmpty()) {
            throw new SecurityException("No Question Found  for Category " + category);
        }

        Quiz quiz = new Quiz();
        quiz.setCategory(category);
        quiz.setQuestions(questions);
        repo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(String category, List<Submit> responses) {

        List<Question> questions = questionPatternRepo.findByCategory(category);

        if (questions.isEmpty()) {
            throw new SecurityException("No Question Found  for Category " + category);
        }

        int right = 0;
        int i = 0;
        for (Submit response : responses) {
            if(response.getAnswer().equals(questions.get(i).getAnswer())){
            right++;
            }
            i++;
        }

     return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
