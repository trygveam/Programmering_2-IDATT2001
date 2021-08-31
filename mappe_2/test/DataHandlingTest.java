package edu.ntnu.idatt2001.trygveam.mappe_2;

import edu.ntnu.idatt2001.trygveam.mappe_2.core.Patient;
import edu.ntnu.idatt2001.trygveam.mappe_2.core.PatientRegister;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class DataHandlingTest {

    private static PatientRegister patientRegister;


    @BeforeAll
    public static void init(){
        patientRegister = new PatientRegister();
    }

    @Test
    public void importAndExport_correctInputs_noExceptionThrown() throws IOException {
        Patient p1 = new Patient("12345678910","First","last","diagnosis","generalPractitioner");
        patientRegister.addPatient(p1);
        File f1 = new File("src/test/resources/edu.ntnu.idatt2001.trygveam.mappe_2/patientsTest.csv");
        Filehandler.loadToFile(f1,patientRegister);
        Assertions.assertTrue(Filehandler.readFromFile(f1).get(0).equals(p1));
    }
}
