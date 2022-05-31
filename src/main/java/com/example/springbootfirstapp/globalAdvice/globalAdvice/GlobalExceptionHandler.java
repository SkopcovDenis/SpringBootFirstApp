package com.example.springbootfirstapp.globalAdvice.globalAdvice;

import com.example.springbootfirstapp.exception.AnswerNotFoundException;
import com.example.springbootfirstapp.payload.response.MessageError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<MessageError> exceptionHandler(AnswerNotFoundException exception) {
        MessageError messageError = new MessageError();
        messageError.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(messageError);
    }
}
