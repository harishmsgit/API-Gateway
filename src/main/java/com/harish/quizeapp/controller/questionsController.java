package com.harish.quizeapp.controller;

import com.harish.quizeapp.model.questions;
import com.harish.quizeapp.service.questionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("question")
public class questionsController {

   @Autowired
   questionService qs;

    @GetMapping("allQuestions" )
    public List<questions> getAllQuestions(){
        return qs.getAllQuestions();
    }
}
