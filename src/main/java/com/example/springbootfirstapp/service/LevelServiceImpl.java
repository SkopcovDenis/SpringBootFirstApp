package com.example.springbootfirstapp.service;

import com.example.springbootfirstapp.entity.Level;
import com.example.springbootfirstapp.entity.Profile;
import com.example.springbootfirstapp.exception.LevelNotFoundException;
import com.example.springbootfirstapp.exception.ProfileNotFoundException;
import com.example.springbootfirstapp.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LevelServiceImpl implements LevelService {

    private LevelRepository levelRepository;

    @Autowired
    public LevelServiceImpl(LevelRepository levelRepository){
        this.levelRepository = levelRepository;
    }

    @Override
    public Level findById(Integer id) {
        return levelRepository.findById(id)
                .orElseThrow(() -> new LevelNotFoundException("Level with id " + id + "not found in database"));
    }

    @Override
    public List<Level> findAll() {

        List<Level> levels = levelRepository.findAll();
        if (levels.isEmpty())
            throw new LevelNotFoundException("Level is not found in database");
        return levels;

    }

    @Override
    public void save(Level level) {
        levelRepository.save(level);
    }

    @Override
    public void update(Level level, Integer id) {
        Level levelById = findById(id);
        level.setName(level.getName())
                .setQuestions(level.getQuestions());
        levelRepository.save(levelById);
    }

    @Override
    public void delete(Integer id) {
        Level level = findById(id);
        levelRepository.delete(level);
    }
}
