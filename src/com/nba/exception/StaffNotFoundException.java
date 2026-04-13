package com.nba.exception;

public class StaffNotFoundException extends RuntimeException {
    public StaffNotFoundException(int id) {
        super("Error: Staff member with ID " + id + " does not exist!");
    }
}
