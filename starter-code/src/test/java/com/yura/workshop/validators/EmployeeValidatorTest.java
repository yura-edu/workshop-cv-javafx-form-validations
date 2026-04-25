package com.yura.workshop.validators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmployeeValidatorTest {

    private EmployeeValidator validator;

    @BeforeEach
    void setUp() {
        validator = new EmployeeValidator();
    }

    // ── validateFullName ──────────────────────────────────────────────────────

    @Test
    void fullName_valid() {
        assertNull(validator.validateFullName("María García"));
    }

    @Test
    void fullName_tooShort_invalid() {
        assertNotNull(validator.validateFullName("Al"));
    }

    @Test
    void fullName_null_invalid() {
        assertNotNull(validator.validateFullName(null));
    }

    @Test
    void fullName_withDigits_invalid() {
        assertNotNull(validator.validateFullName("Ana123"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"María García", "Juan Carlos López", "Ana"})
    void fullName_validVariants(String name) {
        assertNull(validator.validateFullName(name));
    }

    // ── validateEmail ─────────────────────────────────────────────────────────

    @Test
    void email_valid() {
        assertNull(validator.validateEmail("usuario@empresa.com"));
    }

    @Test
    void email_missingAt_invalid() {
        assertNotNull(validator.validateEmail("usuarioempresa.com"));
    }

    @Test
    void email_missingDomain_invalid() {
        assertNotNull(validator.validateEmail("usuario@"));
    }

    @Test
    void email_missingExtension_invalid() {
        assertNotNull(validator.validateEmail("usuario@empresa"));
    }

    @Test
    void email_null_invalid() {
        assertNotNull(validator.validateEmail(null));
    }

    @Test
    void email_empty_invalid() {
        assertNotNull(validator.validateEmail(""));
    }

    // ── validateBirthDate ─────────────────────────────────────────────────────

    @Test
    void birthDate_adult_valid() {
        assertNull(validator.validateBirthDate(LocalDate.now().minusYears(30)));
    }

    @Test
    void birthDate_tooYoung_invalid() {
        assertNotNull(validator.validateBirthDate(LocalDate.now().minusYears(17)));
    }

    @Test
    void birthDate_tooOld_invalid() {
        assertNotNull(validator.validateBirthDate(LocalDate.now().minusYears(66)));
    }

    @Test
    void birthDate_null_invalid() {
        assertNotNull(validator.validateBirthDate(null));
    }

    @Test
    void birthDate_exactly18_valid() {
        assertNull(validator.validateBirthDate(LocalDate.now().minusYears(18)));
    }

    @Test
    void birthDate_exactly65_valid() {
        assertNull(validator.validateBirthDate(LocalDate.now().minusYears(65)));
    }

    // ── validateDepartment ────────────────────────────────────────────────────

    @Test
    void department_valid() {
        assertNull(validator.validateDepartment("Ingeniería"));
    }

    @Test
    void department_null_invalid() {
        assertNotNull(validator.validateDepartment(null));
    }

    @Test
    void department_empty_invalid() {
        assertNotNull(validator.validateDepartment(""));
    }

    // ── validateSalary ────────────────────────────────────────────────────────

    @Test
    void salary_valid() {
        assertNull(validator.validateSalary("1500.00"));
    }

    @Test
    void salary_minimum_valid() {
        assertNull(validator.validateSalary("500"));
    }

    @Test
    void salary_belowMinimum_invalid() {
        assertNotNull(validator.validateSalary("499"));
    }

    @Test
    void salary_negative_invalid() {
        assertNotNull(validator.validateSalary("-100"));
    }

    @Test
    void salary_notANumber_invalid() {
        assertNotNull(validator.validateSalary("mil pesos"));
    }

    @Test
    void salary_null_invalid() {
        assertNotNull(validator.validateSalary(null));
    }

    @Test
    void salary_empty_invalid() {
        assertNotNull(validator.validateSalary(""));
    }

    // ── validatePhoto ─────────────────────────────────────────────────────────

    @Test
    void photo_null_invalid() {
        assertNotNull(validator.validatePhoto(null));
    }

    @Test
    void photo_invalidExtension_invalid() {
        assertNotNull(validator.validatePhoto("/path/to/document.pdf"));
    }

    @Test
    void photo_jpg_valid() {
        assertNull(validator.validatePhoto("/path/to/photo.jpg"));
    }

    @Test
    void photo_png_valid() {
        assertNull(validator.validatePhoto("/path/to/photo.png"));
    }

    @Test
    void photo_jpeg_valid() {
        assertNull(validator.validatePhoto("/path/to/photo.jpeg"));
    }

    @Test
    void photo_upperCaseExtension_valid() {
        assertNull(validator.validatePhoto("/path/to/photo.JPG"));
    }

    // ── isFormValid ───────────────────────────────────────────────────────────

    @Test
    void formValid_allCorrect_valid() {
        assertTrue(validator.isFormValid(
            "María García",
            "maria@empresa.com",
            LocalDate.now().minusYears(30),
            "Ingeniería",
            "1500.00",
            "/path/photo.jpg",
            true
        ));
    }

    @Test
    void formValid_termsNotAccepted_invalid() {
        assertFalse(validator.isFormValid(
            "María García",
            "maria@empresa.com",
            LocalDate.now().minusYears(30),
            "Ingeniería",
            "1500.00",
            "/path/photo.jpg",
            false
        ));
    }

    @Test
    void formValid_invalidEmail_invalid() {
        assertFalse(validator.isFormValid(
            "María García",
            "not-an-email",
            LocalDate.now().minusYears(30),
            "Ingeniería",
            "1500.00",
            "/path/photo.jpg",
            true
        ));
    }

    @Test
    void formValid_belowMinSalary_invalid() {
        assertFalse(validator.isFormValid(
            "María García",
            "maria@empresa.com",
            LocalDate.now().minusYears(30),
            "Ingeniería",
            "100",
            "/path/photo.jpg",
            true
        ));
    }
}
