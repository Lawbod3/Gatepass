package org.bode.com.exceptions;

public class ExistingResident extends RuntimeException {
    public ExistingResident(String message) {
        super(message);
    }
}
