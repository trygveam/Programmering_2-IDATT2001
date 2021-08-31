package edu.ntnu.idatt2001.trygveam.mappe_2.core;

import java.util.Objects;

/**
 * @author trygveam
 * The type Patient.
 */
public class Patient {
    private String socialSecurityNumber;
    private String firstName;
    private String lastName;
    private String diagnosis;
    private String generalPractitioner;

    /**
     * Instantiates a new Patient.
     *
     * @param socialSecurityNumber the social security number
     * @param firstName            the first name
     * @param lastName             the last name
     * @param diagnosis            the diagnosis
     * @param generalPractitioner  the general practitioner
     */
    public Patient(String socialSecurityNumber, String firstName, String lastName, String diagnosis, String generalPractitioner) {
        // calling setters for further validatin, no need to validate in constructor and setters
        setSocialSecurityNumber(socialSecurityNumber);
        setFirstName(firstName);
        setLastName(lastName);
        setDiagnosis(diagnosis);
        setGeneralPractitioner(generalPractitioner);
    }

    /**
     * Gets social security number.
     *
     * @return the social security number
     */
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    /**
     * Sets social security number.
     * @throws IllegalArgumentException if not only digits or not length of 11
     *
     * @param socialSecurityNumber the social security number
     */
    public void setSocialSecurityNumber(String socialSecurityNumber) {
        if(socialSecurityNumber.matches("[0-9]+") && socialSecurityNumber.length() == 11){
            this.socialSecurityNumber = socialSecurityNumber;
        } else throw new IllegalArgumentException("Must be 11 digits");
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name, calling checkIfEmpty that throws exception if empty
     *
     * @param firstName the first name
     *
     */
    public void setFirstName(String firstName) {
        checkIfEmpty(firstName, "First Name");
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name, calling checkIfEmpty that throws exception if empty
     */
    public void setLastName(String lastName) {
        checkIfEmpty(lastName, "Last Name");
        this.lastName = lastName;
    }

    /**
     * Gets diagnosis.
     *
     * @return the diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * Sets diagnosis, does not checkIfEmpty as initial diagnosis could be blank
     *
     * @param diagnosis the diagnosis
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Gets general practitioner
     *
     * @return the general practitioner
     */
    public String getGeneralPractitioner() {
        return generalPractitioner;
    }

    /**
     * Sets general practitioner,does not checkEmpty as initial generalPractitioner is not set, and could be empty
     *
     * @param generalPractitioner the general practitioner
     */
    public void setGeneralPractitioner(String generalPractitioner) {
        this.generalPractitioner = generalPractitioner;
    }

    /**
        private method to check if a certain string is empty
        @param s, string that needs to be checked
        @param param string, parameter that is being checked, displayed in error message if empty
        @throws IllegalArgumentException if string is empty
     */
    private void checkIfEmpty(String s, String param){
        if(s.isEmpty()){
            throw new IllegalArgumentException("String cant be empty in param " + param);
        }
    }

    // ToString method for displaying patients with corresponding information.
    @Override
    public String toString() {
        return "Patient{" +
                "socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", generalPractitioner='" + generalPractitioner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(socialSecurityNumber, patient.socialSecurityNumber) && Objects.equals(firstName, patient.firstName) && Objects.equals(lastName, patient.lastName) && Objects.equals(diagnosis, patient.diagnosis) && Objects.equals(generalPractitioner, patient.generalPractitioner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(socialSecurityNumber, firstName, lastName, diagnosis, generalPractitioner);
    }
}
