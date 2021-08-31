package edu.ntnu.idatt2001.trygveam.mappe_2.core;

import edu.ntnu.idatt2001.trygveam.mappe_2.core.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * @author trygveam
 * The type Patient register.
 */
public class PatientRegister {

    private ObservableList<Patient> patients;

    /**
     * Instantiates a new Patient register.
     * Creating instance of observablelist of patients
     */
    public PatientRegister() {
        this.patients = FXCollections.observableArrayList();
    }

    /**
     * Instantiates a new Patient register.
     *
     * @param patients the patients
     */
    public PatientRegister(ArrayList<Patient> patients) {
        this.patients = FXCollections.observableArrayList(patients);
    }

    /**
     * Add patient.
     *
     * @param patient the patient
     * @throws IllegalArgumentException if patient already in list and if patient is null
     */
    public void addPatient(Patient patient) {
        if (!patients.contains(patient) && !(patient == null)) {
            patients.add(patient);
        } else throw new IllegalArgumentException("Patient cant already be in list and cant be null");
    }

    /**
     * Remove patient method.
     *
     * @param patient the patient
     * @throws IllegalArgumentException if patient not in list or if patient is null
     */
    public void removePatient(Patient patient) {
        if (patients.contains(patient) && !(patient == null)) {
            patients.remove(patient);
        } else throw new IllegalArgumentException("Patient must be in list and cant be null");
    }

    /**
     * Gets patients.
     *
     * @return the patients
     */
    public ObservableList<Patient> getPatients() {
        return this.patients;
    }

    /**
     * Sets patients.
     *
     * @param patients the patients
     */
    public void setPatients(ArrayList<Patient> patients) {
        this.patients = FXCollections.observableArrayList(patients);
    }

}
