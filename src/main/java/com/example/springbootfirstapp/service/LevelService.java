package com.example.springbootfirstapp.service;

import com.example.springbootfirstapp.entity.Level;
import com.example.springbootfirstapp.entity.Profile;

import java.util.List;

public interface LevelService {
    Level findById(Integer id);

    List<Level> findAll();

    void save(Level level);

    void update(Level level, Integer id);

    void delete(Integer id);
}
