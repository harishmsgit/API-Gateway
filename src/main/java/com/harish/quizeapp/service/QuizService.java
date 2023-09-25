package com.harish.quizeapp.service;

import com.harish.quizeapp.dao.QuizDao;
import com.harish.quizeapp.dao.questionDao;
import com.harish.quizeapp.model.QuestionWapper;
import com.harish.quizeapp.model.Quiz;
import com.harish.quizeapp.model.Response;
import com.harish.quizeapp.model.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    questionDao qdao;

    public ResponseEntity<String> createQuiz(String category, int numQuiz, String title) {

        List<questions> question = qdao.findRandomQuestionByCategory(category, numQuiz);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsList(question);
        quizDao.save(quiz);

        return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWapper>> getQuizQuestion(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<questions> questionFromDB = quiz.get().getQuestionsList();
        List<QuestionWapper> questionFrUser = new ArrayList<>();

        for(questions q : questionFromDB){
            QuestionWapper qw = new QuestionWapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionFrUser.add(qw);
        }

        return new ResponseEntity<>(questionFrUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<questions> qs = quiz.getQuestionsList();

        int right = 0;
        int i = 0;

        for(Response response : responses){
            if(response.getResponse().equals(qs.get(i).getRightAnsware()))
                right++;
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
