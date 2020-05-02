package com.assignment.apple.exception;

public class InputValidationException extends Exception {
    public InputValidationException(String errorMessage) {
        super(errorMessage);
    }
}