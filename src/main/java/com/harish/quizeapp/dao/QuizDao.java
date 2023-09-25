package com.harish.quizeapp.dao;

import com.harish.quizeapp.model.Quiz;
import com.harish.quizeapp.model.questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
