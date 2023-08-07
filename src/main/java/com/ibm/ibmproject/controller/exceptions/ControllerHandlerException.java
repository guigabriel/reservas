package com.ibm.ibmproject.controller.exceptions;

import com.ibm.ibmproject.service.exceptions.ObjectNotFoundException;
import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandlerException {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException err, ServletRequest request) {

        StandartError error = new StandartError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), err.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
