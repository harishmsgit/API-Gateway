package com.harish.quizeapp.dao;

import com.harish.quizeapp.model.questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionDao extends JpaRepository<questions, Integer> {

    List<questions> getQuestionByCategory(String category);

    @Query(value = "SELECT * FROM questions q where q.category=:category ORDER BY RANDOM() LIMIT :numQuiz", nativeQuery = true)
    List<questions> findRandomQuestionByCategory(String category, int numQuiz);
}
