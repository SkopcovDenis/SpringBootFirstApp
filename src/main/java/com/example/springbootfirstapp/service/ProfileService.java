package com.example.springbootfirstapp.service;

import com.example.springbootfirstapp.entity.Answer;
import com.example.springbootfirstapp.entity.Profile;

import java.util.List;

public interface ProfileService {
    Profile findById(Integer id);

    List<Profile> findAll();

    void save(Profile profile);

    void update(Profile profile, Integer id);

    void delete(Integer id);
}
