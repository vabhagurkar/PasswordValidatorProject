package org.example;

import org.example.exception.EmptyPasswordException;
import org.example.exception.IncorrectPasswordLengthException;

public interface ValidatorService {

    //Keeping this generic so could be used for various implementations
    boolean validateString(String inputPassword) throws EmptyPasswordException, IncorrectPasswordLengthException;
}
