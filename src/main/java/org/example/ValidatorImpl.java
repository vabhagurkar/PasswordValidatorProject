package org.example;

import org.example.exception.EmptyPasswordException;
import org.example.exception.IncorrectPasswordLengthException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidatorImpl implements ValidatorService{

    Logger logger = Logger.getLogger(ValidatorImpl.class.getName());

    private boolean isValid;

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid){
        this.isValid = isValid;
    }

    public boolean validateString(String inputPassword) throws EmptyPasswordException, IncorrectPasswordLengthException {
       if(inputPassword != null && !inputPassword.isEmpty()){
           String password = inputPassword.trim();
           var passwordLength = password.length();
           if(passwordLength >= 5 && passwordLength <= 10) {
               setValid(true);
               logger.log(Level.INFO,"The password provided is been validated.");
              return true;
           }
           setValid(false);
           logger.log(Level.WARNING,"The length of password is: " + passwordLength + ". It should be between 5 and 10");
           throw new IncorrectPasswordLengthException("The length of password should be between 5 and 10.");
       }
        setValid(false);
        logger.log(Level.WARNING,"Empty password is provided. Please provide a valid password.");
        throw new EmptyPasswordException("Empty string provided");
    }


}
