package com.harish.quizeapp.controller;

import com.harish.quizeapp.model.QuestionWapper;
import com.harish.quizeapp.model.Response;
import com.harish.quizeapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class quizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numQuiz,
                                             @RequestParam String title){

        //return new ResponseEntity<>("I am here", HttpStatus.OK);
        return quizService.createQuiz(category, numQuiz, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWapper>> getQuizQuestion(@PathVariable Integer id){
        return quizService.getQuizQuestion(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }

}
