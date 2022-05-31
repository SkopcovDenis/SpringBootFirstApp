package com.example.springbootfirstapp.repository;

import com.example.springbootfirstapp.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
