package com.ibm.ibmproject.controller.exceptions;

import com.ibm.ibmproject.service.exceptions.HospedeNomeException;
import com.ibm.ibmproject.service.exceptions.QntMinException;
import com.ibm.ibmproject.service.exceptions.ObjectNotFoundException;
import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException err, ServletRequest request) {

        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), err.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(QntMinException.class)
    public ResponseEntity<StandartError> numberTooShort(QntMinException err, ServletRequest request) {
        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), err.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(HospedeNomeException.class)
    public ResponseEntity<StandartError> nameIsTooShort(HospedeNomeException err, ServletRequest request) {
        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), err.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
