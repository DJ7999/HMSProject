package com.app.exception_handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.custom_exception.UnauthorizedException;
import com.app.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	// how to handle validation failures ? : can override existing method.
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		ex.getBindingResult().getFieldErrors()
				.forEach(err -> errors.add(err.getField() + " " + err.getDefaultMessage() + " "));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Validations Failed ", errors));
	}

	@ExceptionHandler(UnauthorizedException.class)	     
	public ResponseEntity<?> unauthorizedException(UnauthorizedException e) {
		System.out.println("hii");
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
				.body(new ErrorResponse("You are not authorized ", Collections.singletonList(e.getMessage())));
	}

	// handle res not found exc
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponse("Invalid id ", Collections.singletonList(e.getMessage())));
	}

	// catch all
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorResponse("Server side Error ", Collections.singletonList(e.getMessage())));
	}

}
