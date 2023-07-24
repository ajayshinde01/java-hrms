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
	public ResponseEntity<?> handleDesignationNotFoundExceptions(DesignationNotFound exception, WebRequest webRequest) {
		ApiResponse response = new ApiResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

	}

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String field = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(field, message);
		});
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
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
		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(GradeException.class)
	public ResponseEntity<?> gradeIdNotPresent(GradeException ex) {
		String message = ex.getMessage();

		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(DepartmentException.class)
	public ResponseEntity<ApiResponse> DataNotFoundException(DepartmentException ex) {
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,LocalDateTime.now());
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
}