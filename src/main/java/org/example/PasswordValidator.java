package org.example;

/**
 * Main class
 *
 */
public class PasswordValidator {

    public static void main( String[] args) {
        try {
            ValidatorImpl validator = new ValidatorImpl();
            validator.validateString("abdc");
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
