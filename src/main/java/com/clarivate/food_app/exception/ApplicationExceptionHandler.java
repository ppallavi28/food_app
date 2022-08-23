package com.clarivate.food_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.clarivate.food_app.util.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFoundException exception){
		ResponseStructure<String> structure = new ResponseStructure<String>();
		structure.setMessage("Id not found in database");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setT("No such id found");
		
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
		
}
