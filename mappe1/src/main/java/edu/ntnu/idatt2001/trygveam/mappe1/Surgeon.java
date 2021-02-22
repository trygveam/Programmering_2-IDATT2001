package edu.ntnu.idatt2001.trygveam.mappe1;

public class Surgeon extends Doctor{
    public Surgeon(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }
    public void setDiagnosis(Patient patient, String diagnosis){
       patient.setDiagnose(diagnosis);
    }
}
