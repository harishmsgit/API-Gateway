package com.harish.quizeapp.dao;

import com.harish.quizeapp.model.questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface questionDao extends JpaRepository<questions, Integer> {

}
