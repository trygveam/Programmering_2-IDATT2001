package edu.ntnu.idatt2001.trygveam.mappe_1.hospital.healthpersonal;

import edu.ntnu.idatt2001.trygveam.mappe_1.hospital.Employee;

/**
 * The type Nurse.
 * @author trygveam
 */
public class Nurse extends Employee {

    /**
     * Instantiates a new Nurse.
     *
     * @param firstName            the first name
     * @param lastName             the last name
     * @param socialSecurityNumber the social security number
     */
    public Nurse(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
