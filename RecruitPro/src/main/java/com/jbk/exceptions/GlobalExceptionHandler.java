package com.jbk.exceptions;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jbk.dto.ExceptionResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public HashMap<String, String> UserException(MethodArgumentNotValidException ex) {
		HashMap<String, String> error=new HashMap<String, String>();
          List<FieldError> fieldErrors = ex.getFieldErrors();	
          for (FieldError fieldError : fieldErrors) {
        	  error.put(fieldError.getField(), fieldError.getDefaultMessage());
			
		}
          return error;
          
	}
	@ExceptionHandler(exception = ResourceNotFoundException.class)
	public ExceptionResponse resourceNotFoundException(ResourceNotFoundException ex,HttpServletRequest req) {
		ExceptionResponse response = new ExceptionResponse();
		response.setUsername(ex.getMessage());
		response.setPath(req.getRequestURI());
		response.setTimestamp(new Timestamp(System.currentTimeMillis()));
		return response;
		
	}

}
       
	

