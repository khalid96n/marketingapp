package com.marketing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marketing.entities.lead;

@ControllerAdvice 
public class HandleException {

	@ExceptionHandler(value = ResourceNotFound.class)
	public ResponseEntity<lead> exception(ResourceNotFound exception){

		return new ResponseEntity<lead>(HttpStatus.BAD_REQUEST);	
		
	}	

	}
