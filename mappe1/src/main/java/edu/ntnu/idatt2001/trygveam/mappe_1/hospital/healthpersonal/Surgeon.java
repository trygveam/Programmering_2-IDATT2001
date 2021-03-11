package edu.ntnu.idatt2001.trygveam.mappe_1.hospital.healthpersonal;

import edu.ntnu.idatt2001.trygveam.mappe_1.hospital.Patient;

/**
 * The type Surgeon.
 * @author trygveam
 */
public class Surgeon extends Doctor {
    /**
     * Instantiates a new Surgeon.
     *
     * @param firstName            the first name
     * @param lastName             the last name
     * @param socialSecurityNumber the social security number
     */
    public Surgeon(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }
    public void setDiagnosis(Patient patient, String diagnosis){
        if(patient == null || diagnosis == null || diagnosis.equals("")){
            throw new IllegalArgumentException("Diagnosis cant be null or blank, and person can't be null");
        }
        else{
            patient.setDiagnose(diagnosis);
        }
    }


}
