package com.harsh.employeeapi.exception;

public class DuplicateIdException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DuplicateIdException(String message) {
        super(message);
    }
}
