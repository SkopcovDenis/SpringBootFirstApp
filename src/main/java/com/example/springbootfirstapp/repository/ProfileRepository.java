package com.example.springbootfirstapp.repository;

import com.example.springbootfirstapp.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
