package com.example.springbootfirstapp.service;

import com.example.springbootfirstapp.entity.Answer;

import java.util.List;

public interface AnswerService {
    Answer findById(Integer id);

    List<Answer> findAll();

    void save(Answer answer);

    void update(Answer answer, Integer id);

    void delete(Integer id);
}
