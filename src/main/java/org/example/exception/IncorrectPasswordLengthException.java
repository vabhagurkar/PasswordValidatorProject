package org.example.exception;

public class IncorrectPasswordLengthException extends Exception{

    public String exceptionMessage;

    public IncorrectPasswordLengthException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
