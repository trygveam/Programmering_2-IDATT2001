package edu.ntnu.idatt2001.trygveam.mappe_1.hospital;

import edu.ntnu.idatt2001.trygveam.mappe_1.hospital.exception.RemoveException;
import org.junit.jupiter.api.*;

public class RemoveExceptionTest {

    private Department department;
    private Patient p1;
    private Employee e1;

    @BeforeEach
    public void init(){
        department = new Department("HearingDepartment");
        p1 =  new Patient("Anders", "Andersen", "10125215588");
        e1 = new Employee("Ole", "Nordmann", "10058965686");
        department.addPatient(p1);
        department.addEmployee(e1);
    }

    @Nested
    class TestingWithCorrectArgument{

        @Test
        @DisplayName("No Exceptions Since Patient is in list")
        public void noExceptionsSincePatientExists(){
            Assertions.assertDoesNotThrow(() -> department.remove(p1));
        }

        @Test
        @DisplayName("No Exceptions Since Employee is in list")
        public void noExceptionsSinceEmployeeExists(){
            Assertions.assertDoesNotThrow(() -> department.remove(e1));
        }
    }

    @Nested
    class TestingWithFalseArgument{

        @Test
        @DisplayName("Correct Exceptions Since Patient not in list")
        public void correctExceptionsSincePatientNotInList(){
            Assertions.assertThrows(RemoveException.class, () -> {
                department.remove(new Employee("not", "excisting", "123441442"));
            });

        }
        @Test
        @DisplayName("Correct Exceptions Since Employee not in list")
        public void correctExceptionsSinceEmployeeNotInList(){
            Assertions.assertThrows(RemoveException.class, ()->{
                department.remove(new Patient("Fins", "ikke-Henriksen", "102515454"));
            });
        }
    }
}
