package com.harish.quizeapp.service;

import com.harish.quizeapp.dao.questionDao;
import com.harish.quizeapp.model.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class questionService {

    @Autowired
    questionDao questiondao;

    public List<questions> getAllQuestions() {
        return questiondao.findAll();
    }
}
