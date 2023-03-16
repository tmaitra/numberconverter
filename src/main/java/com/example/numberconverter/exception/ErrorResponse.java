package com.example.numberconverter.exception;

import java.time.LocalDateTime;

public class ErrorResponse {

	private LocalDateTime timestamp;
	private String error;
	private String message;

	public ErrorResponse(String error, String message) {
		this.timestamp = LocalDateTime.now();
		this.error = error;
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getError() {
		return error;
	}

	public String getMessage() {
		return message;
	}
}