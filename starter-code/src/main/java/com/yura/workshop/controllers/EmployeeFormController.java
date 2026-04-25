package com.yura.workshop.controllers;

import com.yura.workshop.validators.EmployeeValidator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class EmployeeFormController {

    @FXML private TextField fullNameField;
    @FXML private Label fullNameError;

    @FXML private TextField emailField;
    @FXML private Label emailError;

    @FXML private DatePicker birthDatePicker;
    @FXML private Label birthDateError;

    @FXML private ComboBox<String> departmentCombo;
    @FXML private Label departmentError;

    @FXML private TextField salaryField;
    @FXML private Label salaryError;

    @FXML private Label photoLabel;
    @FXML private Label photoError;

    @FXML private CheckBox termsCheckBox;
    @FXML private Button submitButton;

    private final EmployeeValidator validator = new EmployeeValidator();
    private String selectedPhotoPath = null;

    @FXML
    public void initialize() {
        // TODO: populate departmentCombo with options:
        //   Ingeniería, Diseño, Marketing, Recursos Humanos, Finanzas, Operaciones
        departmentCombo.getItems().addAll(List.of(
            "Ingeniería", "Diseño", "Marketing",
            "Recursos Humanos", "Finanzas", "Operaciones"
        ));

        submitButton.setDisable(true);

        // TODO: add focusedProperty listeners to each field so that
        //   when a field loses focus, the validator is called and the
        //   appropriate error label is shown or cleared.

        // TODO: add a listener to termsCheckBox so that checking/unchecking
        //   it re-evaluates updateSubmitButton().
    }

    @FXML
    private void onChoosePhoto() {
        // TODO: open a FileChooser filtered to *.jpg, *.jpeg, *.png
        // TODO: validate the chosen file's extension with validator.validatePhoto()
        // TODO: also check file size (max 5 MB) here with the actual File object
        // TODO: update photoLabel with the file name or show photoError
    }

    @FXML
    private void onSubmit() {
        // TODO: run all validations one final time before submitting
        // TODO: open an Alert (confirmation dialog) showing a summary:
        //   name, email, birth date, department, salary, photo file name
        // TODO: if the user clicks OK/Confirm, show a success Alert
    }

    private void showError(Label errorLabel, String message) {
        // TODO: set errorLabel text and apply a red-border style to the related field
    }

    private void clearError(Label errorLabel) {
        // TODO: clear errorLabel text and apply a green-border style to the related field
    }

    private void updateSubmitButton() {
        // TODO: disable submitButton if any field is invalid or terms are not accepted
    }
}
