package com.harish.quizeapp.dao;

import com.harish.quizeapp.model.questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionDao extends JpaRepository<questions, Integer> {

    List<questions> getQuestionByCategory(String category);

}
