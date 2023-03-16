package com.example.numberconverter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ InvalidRequestFormatException.class })
	public ResponseEntity<Object> handlePaymentValidationException(InvalidRequestFormatException ex) {
		ErrorResponse errorResponse = new ErrorResponse("BE-0002", "Request Validation Failed");
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ NotSupportedOperationException.class })
	public ResponseEntity<Object> handlePaymentResponseNotFoundException(NotSupportedOperationException ex) {
		ErrorResponse errorResponse = new ErrorResponse("BE-0001", "Not supported operation");
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleGenericException(Exception ex) {
		ErrorResponse errorResponse = new ErrorResponse("BE-0003", "Internal server error");
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
