package com.example.springbootfirstapp.exception;

public class LevelNotFoundException extends RuntimeException {
    public LevelNotFoundException(String message) {
        super(message);
    }
}
