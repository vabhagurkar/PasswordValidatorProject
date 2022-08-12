package org.example;

import org.example.exception.EmptyPasswordException;
import org.example.exception.IncorrectPasswordLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for PassWordValidator
 */
public class PassWordValidatorTest {
    ValidatorImpl validatorImpl = new ValidatorImpl();

    @DisplayName("Validator will notify about empty password through exception")
    @Test
    void emptyPasswordExceptionTest() {
        assertThrows(EmptyPasswordException.class, () -> validatorImpl.validateString(""));
        assertFalse(validatorImpl.isValid());
    }

    @DisplayName("Validator will notify about incorrect password length")
    @Test
    void passwordLengthLessTest() {
        assertThrows(IncorrectPasswordLengthException.class, () -> validatorImpl.validateString("x"));
        assertFalse(validatorImpl.isValid());
    }

    @DisplayName("Validator will notify about incorrect password length")
    @Test
    void passwordLengthLongerTest() {
        assertThrows(IncorrectPasswordLengthException.class, () -> validatorImpl.validateString("xa1234-1991111"));
        assertFalse(validatorImpl.isValid());
    }

    @DisplayName("Validator will notify about incorrect password length")
    @Test
    void allSpacesPasswordException() {
        assertThrows(IncorrectPasswordLengthException.class, () -> validatorImpl.validateString("      "));
        assertFalse(validatorImpl.isValid());
    }

    @DisplayName("Validator will not count spaces if spaces are at the boundaries the characters")
    @Test
    void combinationOfStartSPacesAndCharsPasswordException() {
        assertThrows(IncorrectPasswordLengthException.class, () -> validatorImpl.validateString("  a80y "));
        assertFalse(validatorImpl.isValid());
    }

    @DisplayName("Validator will count spaces if included inside the characters")
    @Test
    void combinationOfInclusiveSPacesAndCharsPasswordVerified() throws EmptyPasswordException,
            IncorrectPasswordLengthException {
        assertTrue(validatorImpl.validateString("a8  -oo"));
        assertTrue(validatorImpl.isValid());
    }

    @DisplayName("Validator will validate password")
    @Test
    void validPasswordVerified() throws EmptyPasswordException, IncorrectPasswordLengthException {
        assertTrue(validatorImpl.validateString("a8-ooi77"));
        assertTrue(validatorImpl.isValid());
    }
}
