package edu.ntnu.idatt2001.trygveam.mappe_2;

import edu.ntnu.idatt2001.trygveam.mappe_2.core.Patient;
import edu.ntnu.idatt2001.trygveam.mappe_2.core.PatientRegister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PatientRegisterTest {

    private static PatientRegister patientRegister;
    private static Patient patient;

    @BeforeAll
    public static void init(){
        patientRegister = new PatientRegister();
        patient = new Patient("12345678910","First","last","diagnosis","generalPractitioner");
        patientRegister.addPatient(patient);
    }

    @Test
    public void addPatient_patientNotInList_noExceptionThrown(){
        Assertions.assertDoesNotThrow(()->patientRegister.addPatient(new Patient("22345678910","First","last","diagnosis","generalPractitioner")));
    }
    @Test
    public void addPatient_inputAsNull_throwsException(){
        Assertions.assertThrows(IllegalArgumentException.class,()->patientRegister.addPatient(null));
    }


    @Test
    public void removePatient_patientInList_noExceptionThrown(){
        Assertions.assertDoesNotThrow(()->patientRegister.removePatient(patient));
    }
    @Test
    public void removePatient_patientNotInList_throwsException(){
        Assertions.assertThrows(IllegalArgumentException.class,()->patientRegister.removePatient(new Patient("22345978910","First","last","diagnosis","generalPractitioner")));
    }





}
