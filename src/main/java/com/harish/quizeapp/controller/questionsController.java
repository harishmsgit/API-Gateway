package com.harish.quizeapp.controller;

import com.harish.quizeapp.model.questions;
import com.harish.quizeapp.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class questionsController {

   @Autowired
   questionService qs;

    @GetMapping("allQuestions" )
    public ResponseEntity<List<questions>> getAllQuestions(){
        return qs.getAllQuestions();
    }

   /* @GetMapping("category/{cat}")
    public List<questions> getQuestionByCategoty(@PathVariable("cat") String category){
    }*/
    @GetMapping("category/{category}")
    public ResponseEntity<List<questions>> getQuestionByCategory(@PathVariable String category){
        return qs.getQuestionByCategory(category);
    }

    @PostMapping("add")  //not working addition. database id generation issue.
    public ResponseEntity<String> addQuestions(@RequestBody questions question){
        return qs.addQuestions(question);
    }
}
