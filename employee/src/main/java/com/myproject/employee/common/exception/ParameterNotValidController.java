package com.myproject.employee.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ParameterNotValidController {

	 @ExceptionHandler(value = ParameterNotValidException.class)
	   public ResponseEntity<Object> exception(ParameterNotValidException exception) {
	      return new ResponseEntity<>("SortBy Parameter not valid", HttpStatus.BAD_REQUEST);
	   }
}
