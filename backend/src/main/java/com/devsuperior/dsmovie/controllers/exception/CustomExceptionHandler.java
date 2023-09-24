package com.devsuperior.dsmovie.controllers.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, HttpServletRequest request) {

        return new ResponseEntity<>(responseBodyBuilder(request), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, HttpServletRequest request){
        return new ResponseEntity<>(responseBodyBuilder(request), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, HttpServletRequest request) {

        return new ResponseEntity<>(responseBodyBuilder(request), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, HttpServletRequest request) {

        return new ResponseEntity<>(responseBodyBuilder(request), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(ArrayIndexOutOfBoundsException ex,
        HttpServletRequest request) {

        return new ResponseEntity<>(responseBodyBuilder(request), HttpStatus.NOT_FOUND);
    }


    private Map<String, Object> responseBodyBuilder(HttpServletRequest request) {
        
        Map<String, Object> body = new LinkedHashMap<>();
        
        body.put("date", LocalDateTime.now());
        body.put("path", request.getRequestURI());
        
        return body;
    }
}
