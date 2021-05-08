package edu.ntnu.idatt2001.trygveam.mappe_1.hospital.healthpersonal;

import edu.ntnu.idatt2001.trygveam.mappe_1.hospital.Employee;
import edu.ntnu.idatt2001.trygveam.mappe_1.hospital.Patient;

/**
 * The type Doctor.
 * @author trygveam
 */
public abstract class Doctor extends Employee {


    /**
     * Instantiates a new Doctor.
     *
     * @param firstName            the first name
     * @param lastName             the last name
     * @param socialSecurityNumber the social security number
     */
    public Doctor(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    /**
     * Sets diagnosis.
     *
     * @param patient   the patient
     * @param diagnosis the diagnosis
     */
    public abstract void setDiagnosis(Patient patient, String diagnosis);
}
