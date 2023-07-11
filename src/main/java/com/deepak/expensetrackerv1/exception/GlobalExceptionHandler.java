package com.deepak.expensetrackerv1.exception;

import com.deepak.expensetrackerv1.entities.ErrorObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ResourceNotFoundException ex) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorObject> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(BadRequestException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", new Date());
        body.put("statusCode", HttpStatus.BAD_REQUEST.value());
        body.put("messages", ex.getObj());
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("My-Header", "MyHeaderValue");
        return new ResponseEntity<>(body, headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemAlreadyExistsException.class)
    public ResponseEntity<ErrorObject> handleItemAlreadyExistsException(ItemAlreadyExistsException ex) {
        ex.printStackTrace();
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.CONFLICT.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<>(errorObject, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleGeneralException(Exception ex) {
        ex.printStackTrace();
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return ResponseEntity.internalServerError().body(errorObject);
    }

}

