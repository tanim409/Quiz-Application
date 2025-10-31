package com.QuizApplication.service;

import com.QuizApplication.DTO.Course.QuestionRequest;
import com.QuizApplication.DTO.Course.QuestionResponse;
import com.QuizApplication.exception.SecurityException;
import com.QuizApplication.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.QuizApplication.repo.QuestionPatternRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionPatternService {

    @Autowired
    QuestionPatternRepo repo;

    public ResponseEntity<List<QuestionResponse>> getQuestion() {

        if (repo.findAll().isEmpty()) {
            throw new SecurityException("No Question Found");
        }
        return new ResponseEntity<>(repo.findAll()
                .stream()
                .map(this::convertToDo)
                .collect(Collectors.toList()), HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionResponse>> getQusByCategory(String category) throws Exception {
        if (repo.findByCategory(category).isEmpty()) {
            throw new SecurityException("No Question Found" + category);
        }
        return new ResponseEntity<>(repo.findByCategory(category)
                .stream()
                .map(this::convertToDo)
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    public ResponseEntity<QuestionResponse> AddQuestion(QuestionRequest question) {

        Question q = new Question();
        q.setQuestion(question.getQuestion());
        q.setCategory(question.getCategory());
        q.setOptionA(question.getOptionA());
        q.setOptionB(question.getOptionB());
        q.setOptionC(question.getOptionC());
        q.setOptionD(question.getOptionD());
        q.setAnswer(question.getAnswer());
        q.setDifficultyLevel(question.getDifficultyLevel());

        return new ResponseEntity<>(convertToDo(repo.save(q)), HttpStatus.OK);
    }

    QuestionResponse convertToDo(Question question) {
        QuestionResponse qr = new QuestionResponse();
        qr.setId(question.getId());
        qr.setQuestion(question.getQuestion());
        qr.setOptionA(question.getOptionA());
        qr.setOptionB(question.getOptionB());
        qr.setOptionC(question.getOptionC());
        qr.setOptionD(question.getOptionD());
        qr.setAnswer(question.getAnswer());
        qr.setCategory(question.getCategory());
        qr.setDifficultyLevel(question.getDifficultyLevel());


        return qr;
    }
}
