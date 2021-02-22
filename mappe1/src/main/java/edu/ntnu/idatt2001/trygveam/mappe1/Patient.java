package edu.ntnu.idatt2001.trygveam.mappe1;

public class Patient extends Person implements Diagnosable {
    private String diagnosis;

    public Patient(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public void setDiagnose(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return super.toString() + "Patient{" +
                "diagnosis='" + diagnosis + '\'' +
                '}';
    }
}
