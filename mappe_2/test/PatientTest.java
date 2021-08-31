package edu.ntnu.idatt2001.trygveam.mappe_2;

import edu.ntnu.idatt2001.trygveam.mappe_2.core.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.awt.geom.PathIterator;

public class PatientTest {
    private static Patient patient;

    @BeforeAll
    static void init(){
        patient = new Patient("12345678910","First","last","diagnosis","generalPractitioner");
    }

    @Test
    public void setFirstName_simpleString_noExceptionThrown(){
        Assertions.assertDoesNotThrow(()->patient.setFirstName("firstName"));
    }
    @Test
    public void setFirstName_emptyString_ExceptionThrown(){
        Assertions.assertThrows(IllegalArgumentException.class,()->patient.setFirstName(""));
    }

    @Test
    public void setLastName_simpleString_noExceptionThrown(){
        Assertions.assertDoesNotThrow(()->patient.setLastName("lastName"));
    }
    @Test
    public void setLastName_emptyString_ExceptionThrown(){
        Assertions.assertThrows(IllegalArgumentException.class,()->patient.setLastName(""));
    }

    @Test
    public void setSocialSecurityNumber_simpleString_noExceptionThrown(){
        Assertions.assertDoesNotThrow(()->patient.setSocialSecurityNumber("12345678914"));
    }
    @Test
    public void setSocialSecurityNumber_unCorrectLenghtOfNumber_ExceptionThrown(){
        Assertions.assertThrows(IllegalArgumentException.class,()->patient.setSocialSecurityNumber("1234"));
    }

}
