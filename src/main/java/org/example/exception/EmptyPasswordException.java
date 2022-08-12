package org.example.exception;

public class EmptyPasswordException extends Exception {

    public String exceptionMessage;

    public EmptyPasswordException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
