package com.harish.quizeapp.controller;

import com.harish.quizeapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
