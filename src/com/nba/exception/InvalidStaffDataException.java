package com.nba.exception;

public class InvalidStaffDataException extends RuntimeException {
    public InvalidStaffDataException(String message) {
        super(message);
    }
}
