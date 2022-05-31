package com.example.springbootfirstapp.service;

import com.example.springbootfirstapp.entity.Answer;
import com.example.springbootfirstapp.exception.AnswerNotFoundException;
import com.example.springbootfirstapp.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer findById(Integer id) {
        return answerRepository.findById(id)
                .orElseThrow(() -> new AnswerNotFoundException("Answer with id " + id + "not found in database"));
    }

    @Override
    public List<Answer> findAll() {
        List<Answer> answers = answerRepository.findAll();
        if (answers.isEmpty())
            throw new AnswerNotFoundException("Answer is not found in database");
        return answers;
    }

    @Override
    public void save(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void update(Answer answer, Integer id) {
        Answer answerById = findById(id);
        answer.setCorrect(answer.getCorrect())
                .setName(answer.getName())
                .setQuestion(answer.getQuestion());
        answerRepository.save(answerById);
    }

    @Override
    public void delete(Integer id) {
        Answer answer = findById(id);
        answerRepository.delete(answer);
    }
}
