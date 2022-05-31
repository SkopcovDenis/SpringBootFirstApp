package com.example.springbootfirstapp.service;

import com.example.springbootfirstapp.entity.Answer;
import com.example.springbootfirstapp.entity.Question;
import com.example.springbootfirstapp.exception.AnswerNotFoundException;
import com.example.springbootfirstapp.exception.QuestionNotFoundException;
import com.example.springbootfirstapp.repository.AnswerRepository;
import com.example.springbootfirstapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question findById(Integer id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new QuestionNotFoundException("Question with id " + id + "not found in database"));
    }

    @Override
    public List<Question> findAll() {
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty())
            throw new QuestionNotFoundException("Question is not found in database");
        return questions;
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void update(Question question, Integer id) {
        Question questionById = findById(id);
        question.setNumOfCorrect(question.getNumOfCorrect())
                .setName(question.getName())
                .setAnswers(question.getAnswers());
        questionRepository.save(questionById);
    }

    @Override
    public void delete(Integer id) {
        Question question = findById(id);
        questionRepository.delete(question);
    }
}
