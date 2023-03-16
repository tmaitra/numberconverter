package com.example.numberconverter.exception;

public class InvalidRequestFormatException extends RuntimeException {
    private static final long serialVersionUID = 9206741770650650911L;

	public InvalidRequestFormatException(String message) {
        super(message);
    }
}