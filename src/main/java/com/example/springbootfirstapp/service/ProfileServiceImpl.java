package com.example.springbootfirstapp.service;

import com.example.springbootfirstapp.entity.Profile;
import com.example.springbootfirstapp.entity.Question;
import com.example.springbootfirstapp.exception.ProfileNotFoundException;
import com.example.springbootfirstapp.exception.QuestionNotFoundException;
import com.example.springbootfirstapp.repository.AnswerRepository;
import com.example.springbootfirstapp.repository.ProfileRepository;
import com.example.springbootfirstapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile findById(Integer id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("Profile with id " + id + "not found in database"));
    }

    @Override
    public List<Profile> findAll() {

        List<Profile> profiles = profileRepository.findAll();
        if (profiles.isEmpty())
            throw new ProfileNotFoundException("Profile is not found in database");
        return profiles;
    }

    @Override
    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    @Override
    public void update(Profile profile, Integer id) {
        Profile profileById = findById(id);
        profile.setName(profile.getName())
                .setQuestions(profile.getQuestions());
        profileRepository.save(profileById);
    }

    @Override
    public void delete(Integer id) {
        Profile profile = findById(id);
        profileRepository.delete(profile);
    }
}
