package com.harish.quizeapp.service;

import com.harish.quizeapp.dao.QuizDao;
import com.harish.quizeapp.dao.questionDao;
import com.harish.quizeapp.model.Quiz;
import com.harish.quizeapp.model.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    public ResponseEntity<String> createQuiz(String category, int numQuiz, String title) {

        List<questions> question = quizDao.findRandomQuestionByCategory(category, numQuiz);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsList(question);

        quizDao.save(quiz);

        return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
    }

}
