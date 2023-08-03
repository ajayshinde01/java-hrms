package com.avisys.empmgmt.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
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
	public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
		 Map<String, List<String>> fieldErrors = new HashMap<>();
	        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	            String fieldName = error.getField();
	            String errorMessage = error.getDefaultMessage();
	            fieldErrors.computeIfAbsent(fieldName, k -> new ArrayList<>()).add(errorMessage);
	        }
		return new ResponseEntity<>(fieldErrors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DataAlreadyPresentException.class)
	public ResponseEntity<String> DataAlreadyPresentException(DataAlreadyPresentException ex) {

		return new ResponseEntity(new ApiResponse("Data Already Present..."), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DesignationNotFound.class)
	public ResponseEntity<?> handleDesignationNotFoundExceptions(DesignationNotFound exception, WebRequest webRequest) {
		ApiResponse response = new ApiResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}


	@ExceptionHandler(value = NoRoleFoundException.class)

	public ResponseEntity<Object> exception(NoRoleFoundException exception) {
		return new ResponseEntity(new ApiResponse("Role not found"), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = EmptyListException.class)

	public ResponseEntity<Object> exception(EmptyListException exception) {
		return new ResponseEntity<>(new ApiResponse("No Records found"), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidInputException.class)

	public ResponseEntity<Object> exception(InvalidInputException exception) {
		return new ResponseEntity<>(
				"Field should not be blank, should not contain number and should not contain special characters",
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = RoleAlreadyPresentException.class)
	public ResponseEntity<Object> exception(RoleAlreadyPresentException exception) {
		return new ResponseEntity<>(
				new ApiResponse("Role already present or Role Id is already taken. Try for another Role Id"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DivisionNotFound.class)
	public ResponseEntity<?> handleDivisionNotFoundException(DivisionNotFound divisionNotFound) {

		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage(divisionNotFound.getMessage());
		apiResponse.setDateTime(LocalDateTime.now());
		return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(GradeException.class)
	public ResponseEntity<?> gradeIdNotPresent(GradeException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(DepartmentException.class)
	public ResponseEntity<ApiResponse> DataNotFoundException(DepartmentException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<ApiResponse> DataNotFoundException(EmployeeException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<ApiResponse> DataNotFoundException(AddressException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CompanyDetailAlreadyPresent.class)
	public ResponseEntity<?> CompanyDetailAlreadyPresent(CompanyDetailAlreadyPresent exception, WebRequest webRequest) {
		ApiResponse response = new ApiResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}   
	
	@ExceptionHandler(CompanyDetailNotFound.class)
	public ResponseEntity<?> CompanyDetailNotFound(CompanyDetailNotFound exception, WebRequest webRequest) {
		ApiResponse response = new ApiResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

    @ExceptionHandler(NoPersonalDetailsFound.class)
	public ResponseEntity<?> handleNoPersonalDetailsFoundException(NoPersonalDetailsFound exception, WebRequest webRequest) {
		ApiResponse response = new ApiResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}
       	
    @ExceptionHandler(DuplicatePersonalDetail.class)
	public ResponseEntity<?> handleDuplicatePersonalDetailException(DuplicatePersonalDetail exception, WebRequest webRequest) {
		ApiResponse response = new ApiResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}   
       	

    @ExceptionHandler(JoiningDetailAlreadyPresent.class)
	public ResponseEntity<?> handleJoiningDetailAlreadyPresentException(JoiningDetailAlreadyPresent exception, WebRequest webRequest) {
		ApiResponse response = new ApiResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}
       	
    @ExceptionHandler(JoiningDetailNotFound.class)
	public ResponseEntity<?> handleJoiningDetailNotFoundException(JoiningDetailNotFound exception, WebRequest webRequest) {
		ApiResponse response = new ApiResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(EmergencyContactsException.class)
	public ResponseEntity<ApiResponse> DataNotFoundException(EmergencyContactsException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(VisaException.class)
	public ResponseEntity<ApiResponse> DataNotFoundException(VisaException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EducationalQualificationException.class)
	public ResponseEntity<ApiResponse> DataNotFoundException(EducationalQualificationException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(WorkExperienceException.class)
	public ResponseEntity<ApiResponse> DataNotFoundException(WorkExperienceException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);

	}
}