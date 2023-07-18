package com.avisys.empmgmt.exception;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.avisys.empmgmt.util.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleDataNotFoundException(ResourceNotFoundException exception, WebRequest request) {
		Error_Details error_Details = new Error_Details(new Date(), exception.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(error_Details, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
		String errorMessage = errors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(Collectors.joining(", "));
		return ResponseEntity.badRequest().body(errorMessage);
	}

	@ExceptionHandler(DataAlreadyPresentException.class)
	public ResponseEntity<String> DataAlreadyPresentException(DataAlreadyPresentException ex) {

		return new ResponseEntity(new ApiResponse("Data Already Present..."), HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler(DesignationNotFound.class)
	    public ResponseEntity<?> handleDesignationNotFoundExceptions( DesignationNotFound exception, WebRequest webRequest) {
	        ApiResponse response = new ApiResponse();
	        response.setDateTime(LocalDateTime.now());
	        response.setMessage(exception.getMessage());
	        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	         
	    }
	 
	 protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		 Map<String, String> errors=new HashMap<>();
		 ex.getBindingResult().getAllErrors().forEach((error)->{
			 String field=((FieldError) error).getField();
			 String message=error.getDefaultMessage();
			 errors.put(field,message);
		 });
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}
}