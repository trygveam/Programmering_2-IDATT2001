package edu.ntnu.idatt2001.trygveam.mappe_1.hospital;

/**
 * The type Patient.
 */
public class Patient extends Person implements Diagnosable {
    private String diagnosis;

    /**
     * Instantiates a new Patient.
     *
     * @param firstName            the first name
     * @param lastName             the last name
     * @param socialSecurityNumber the social security number
     */
    public Patient(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public void setDiagnose(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Gets diagnosis.
     *
     * @return the diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        StringBuilder sB = new StringBuilder();
        sB.append(super.toString());
        sB.append("Diagnosis : ").append(diagnosis);
        return sB.toString();

    }
}
