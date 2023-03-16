package com.example.numberconverter.exception;

public class NotSupportedOperationException extends RuntimeException {
    private static final long serialVersionUID = 726792714907146685L;

	public NotSupportedOperationException(String message) {
        super(message);
    }
}