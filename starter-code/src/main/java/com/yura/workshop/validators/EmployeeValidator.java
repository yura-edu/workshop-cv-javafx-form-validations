package com.yura.workshop.validators;

import java.time.LocalDate;

/**
 * Pure validation logic — zero JavaFX dependencies.
 * Implement every method so that EmployeeValidatorTest passes.
 *
 * Return contract:
 *   null  → field is valid
 *   String → error message to display under the field
 */
public class EmployeeValidator {

    /**
     * Full name must have at least 3 characters and contain only letters and spaces.
     */
    public String validateFullName(String name) {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Email must contain '@', a domain name, and a domain extension (e.g. .com).
     */
    public String validateEmail(String email) {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Employee must be between 18 and 65 years old (inclusive).
     */
    public String validateBirthDate(LocalDate date) {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Department must not be null or blank.
     */
    public String validateDepartment(String department) {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Salary must be a positive number with up to 2 decimal places and at least 500.
     */
    public String validateSalary(String salary) {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Photo file path must end in .jpg, .jpeg, or .png (case-insensitive).
     * Size enforcement is done by the controller with a real File object.
     */
    public String validatePhoto(String filePath) {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }

    /**
     * Returns true only when all individual validations pass and terms are accepted.
     */
    public boolean isFormValid(
            String fullName,
            String email,
            LocalDate birthDate,
            String department,
            String salary,
            String photoPath,
            boolean termsAccepted) {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
