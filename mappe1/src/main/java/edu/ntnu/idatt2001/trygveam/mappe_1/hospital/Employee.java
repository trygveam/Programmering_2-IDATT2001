package edu.ntnu.idatt2001.trygveam.mappe_1.hospital;

/**
 * The type Employee.
 * @author trygveam
 */
public class Employee extends Person{

    /**
     * Instantiates a new Employee.
     *
     * @param firstName            the first name
     * @param lastName             the last name
     * @param socialSecurityNumber the social security number
     */
    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
