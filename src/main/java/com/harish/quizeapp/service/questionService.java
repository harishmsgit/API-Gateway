package com.harish.quizeapp.service;

import com.harish.quizeapp.dao.questionDao;
import com.harish.quizeapp.model.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class questionService {

    @Autowired
    questionDao dao;

    public ResponseEntity<List<questions>> getAllQuestions() {
        try{
            return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<questions>> getQuestionByCategory(String category) {

        try{
            return new ResponseEntity<>(dao.getQuestionByCategory(category), HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestions(questions question) {

        try{
            dao.save(question);
            return new ResponseEntity<>("SUCCESS", HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Data insertion error", HttpStatus.BAD_REQUEST);
    }
}
