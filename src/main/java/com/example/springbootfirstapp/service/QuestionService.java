package com.example.springbootfirstapp.service;

import com.example.springbootfirstapp.entity.Answer;
import com.example.springbootfirstapp.entity.Question;

import java.util.List;

public interface QuestionService {
    Question findById(Integer id);

    List<Question> findAll();

    void save(Question question);

    void update(Question question, Integer id);

    void delete(Integer id);
}
