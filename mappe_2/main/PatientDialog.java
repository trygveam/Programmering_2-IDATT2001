package edu.ntnu.idatt2001.trygveam.mappe_2;

import edu.ntnu.idatt2001.trygveam.mappe_2.core.Patient;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

/**
 * @author trygveam
 * The type Patient dialog.
 */
public class PatientDialog extends Dialog<Patient> {
    private App app;

    /**
     * Instantiates a new Patient dialog.
     *
     * @param app  the app
     * @param edit the edit
     */
    public PatientDialog(App app,boolean edit){
        // Calling super class Dialog
        super();
        this.app = app;
        // Calling method for creating dialog with param edit
        createDialog(edit);
    }

    /**
     * Method for creating dialog for edit and add patient,
     * dialog differs from input ( true/false)
     *
     * @param edit
     */

    public void createDialog(boolean edit) {
        ButtonType addButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
        super.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        TextField firstName = new TextField();
        TextField lastName = new TextField();
        TextField ssn = new TextField();
        Patient selectedPatient = app.getTableView().getSelectionModel().getSelectedItem();
        // If edit is true, adding title and setting current information of patient in textfields
        if(edit) {
            super.setTitle("Edit Patient Dialog");
            firstName.setText(selectedPatient.getFirstName());
            lastName.setText(selectedPatient.getLastName());
            ssn.setText(selectedPatient.getSocialSecurityNumber());
            grid.add(new Label("First Name:"), 0, 0);
            grid.add(firstName, 1, 0);
            grid.add(new Label("Last Name:"), 0, 1);
            grid.add(lastName, 1, 1);
            grid.add(new Label("Social Security:"), 0, 2);
            grid.add(ssn, 1, 2);
        }else {
            firstName.setPromptText("First Name");
            lastName.setPromptText("Last Name");
            ssn.setPromptText("Social Security Number");
            super.setTitle("Add Patient Dialog");
            grid.add(new Label("First Name:"), 0, 0);
            grid.add(firstName, 1, 0);
            grid.add(new Label("Last Name:"), 0, 1);
            grid.add(lastName, 1, 1);
            grid.add(new Label("Social Security:"), 0, 2);
            grid.add(ssn, 1, 2);
        }
            // Creating variable for add button to be able to disable it if arguments are not correct, see validation below
            Node addButton = super.getDialogPane().lookupButton(addButtonType);
            addButton.setDisable(true);

            // Validation for socialSecurityNumber, firstName and lastName. Checks for ifEmpty and the lenth of the number.
            ssn.textProperty().addListener((observable, oldValue, newValue) -> {
                addButton.setDisable(!(newValue.matches("[0-9]+") && newValue.length() == 11));
            });
            addButton.setDisable(true);
            lastName.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.trim().isEmpty()) {
                    addButton.setDisable(false);
                } else {
                    addButton.setDisable(true);
                }
            });
            firstName.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!newValue.trim().isEmpty()) {
                    addButton.setDisable(false);
                } else {
                    addButton.setDisable(true);
                }
            });
            super.getDialogPane().setContent(grid);

            // Request focus on the username field by default.
            Platform.runLater(firstName::requestFocus);

            if(edit) {
                // Convert the result to a username-password-pair when the login button is clicked.
                super.setResultConverter(dialogButton -> {
                    if (dialogButton == addButtonType) {
                        return new Patient(ssn.getText(), firstName.getText(), lastName.getText(), selectedPatient.getDiagnosis(), selectedPatient.getGeneralPractitioner());
                    }
                    return null;
                });
                Optional<Patient> result = super.showAndWait();
                result.ifPresent(patient -> {
                    selectedPatient.setFirstName(patient.getFirstName());
                    selectedPatient.setLastName(patient.getLastName());
                    selectedPatient.setSocialSecurityNumber(patient.getSocialSecurityNumber());
                });
                app.updateStatusBar("Edited Patient");
            } else{

            // Convert the result to a username-password-pair when the login button is clicked.
            super.setResultConverter(dialogButton -> {
                if (dialogButton == addButtonType) {
                    return new Patient(ssn.getText(), firstName.getText(), lastName.getText(), " diagnosis", "general");
                }
                return null;
            });
            Optional<Patient> result = super.showAndWait();
            result.ifPresent(patient -> {
                app.getPatientRegister().addPatient(new Patient(ssn.getText(), firstName.getText(), lastName.getText(), " diagnosis", "general"));
            });
            app.updateStatusBar("Patient Added");
        }
        // Updating tableview after editing or adding Patient, for result to be displayed / updated
        app.tableView.refresh();
    }

    }
