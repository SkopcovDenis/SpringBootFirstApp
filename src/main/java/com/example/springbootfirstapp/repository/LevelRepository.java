package com.example.springbootfirstapp.repository;

import com.example.springbootfirstapp.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Integer> {
}
