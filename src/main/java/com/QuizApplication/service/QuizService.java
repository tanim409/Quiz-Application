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
import java.util.stream.Stream;     
@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionPatternRepo questionPatternRepo;

    public List<QuizResponse> quizResponse(String category) throws Exception {

        Quiz quizzes = quizRepo.findByCategory(category);

        if (quizzes.getQuestions().isEmpty()) {
            throw new SecurityException("No Question Found for Category " + category);
        }
        return quizzes.getQuestions().stream()
                .map(this::ConvertToQuizResponse)
                .collect(Collectors.toList());
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
        quizRepo.save(quiz);
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
