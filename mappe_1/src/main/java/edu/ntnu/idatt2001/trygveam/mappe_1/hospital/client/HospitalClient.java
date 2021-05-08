package edu.ntnu.idatt2001.trygveam.mappe_1.hospital.client;

import edu.ntnu.idatt2001.trygveam.mappe_1.hospital.*;
import edu.ntnu.idatt2001.trygveam.mappe_1.hospital.exception.RemoveException;

/**
 * @author trygveam
 */

public class HospitalClient {
    public static void main(String[] args){
        Hospital h1 = new Hospital("St.olavs");
        HospitalTestData.fillRegisterWithTestData(h1);

        System.out.println(h1.getDepartments().get(0).getEmployees());

        // This try, catch should not catch an RemoveException since the employee exist.
        Department akutten = h1.getDepartments().get(0);
        Employee e1 = akutten.getEmployees().get("1");
        try {
            akutten.remove(e1);
        } catch (RemoveException e) {
            e.printStackTrace();
        }

        System.out.println(h1.getDepartments().get(0).getEmployees());
        // This try, catch should catch an RemoveException since ole Halvorsen does not exist.
        Employee e2 = new Employee("ole", "halvorsen", "198");
        try {
            akutten.remove(e2);
        } catch (RemoveException e) {
            e.printStackTrace();
        }


    }
}
