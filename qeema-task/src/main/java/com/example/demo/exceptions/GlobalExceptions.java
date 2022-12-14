package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptions {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ProductNotFoundException> handelProductNotFoundException(Exception ex,WebRequest request) {
		return new ResponseEntity(ex.getMessage(),HttpStatus.NOT_FOUND);
		}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> handleExceptions(Exception ex,WebRequest request) {
		return new ResponseEntity(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
}
}
