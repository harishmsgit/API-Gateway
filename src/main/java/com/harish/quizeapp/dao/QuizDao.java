package com.harish.quizeapp.dao;

import com.harish.quizeapp.model.Quiz;
import com.harish.quizeapp.model.questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

    @Query(value = "SELECT FROM questions q where q.category=:category ORDER BY RANDOM() LIMIT :numQuiz", nativeQuery = true)
    List<questions> findRandomQuestionByCategory(String category, int numQuiz);
}
