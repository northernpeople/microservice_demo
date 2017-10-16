package com.stepan.microservice.web.rest.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.stepan.microservice.web.rest.exception.NotFoundException;
import com.stepan.microservice.web.rest.exception.ValidationException;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@ControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error handleUserNotFoundException(NotFoundException ex) {
		return new Error();
	}
	
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Map<String, String>> handleValidationException(ValidationException ex) {
		return new ResponseEntity<Map<String, String>>(ex.getValidationErrors(), HttpStatus.BAD_REQUEST);
	}

	
}