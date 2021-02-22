package edu.ntnu.idatt2001.trygveam.mappe1;

public abstract class Doctor extends Employee {

    public Doctor(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }
    public abstract void setDiagnosis(Patient patient, String diagnosis);
}
