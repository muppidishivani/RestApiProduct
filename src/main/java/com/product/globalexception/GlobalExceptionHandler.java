package com.product.globalexception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.product.exception.ProductIdNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> globalExceptionHandler(MethodArgumentNotValidException ex)
	{
		  BindingResult result=ex.getBindingResult();
		  
		  Map<String,String> validErrors=new HashMap();
		  for(FieldError fielderrors: result.getFieldErrors())
		  {
			  validErrors.put(fielderrors.getField(), fielderrors.getDefaultMessage());
			  
		  }
		  
		return new ResponseEntity(validErrors,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<String> productIdExceptionHandler(ProductIdNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		
	}

}
