package edu.ntnu.idatt2001.trygveam.mappe_1.hospital;

import edu.ntnu.idatt2001.trygveam.mappe_1.hospital.exception.RemoveException;

import java.util.HashMap;
import java.util.Objects;

/**
 * The type Department.
 * @author trygveam
 */
public class Department {
    private String departmentName;
    private final HashMap<String,Employee> employees;
    private final HashMap<String,Patient> patients;

    /**
     * Instantiates a new Department.
     *
     * @param departmentName the department name
     */
    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employees = new HashMap<>();
        this.patients = new HashMap<>();
    }


    public String getDepartmentName() {
        return departmentName;
    }


    public void setDepartmentName(String departmentName) {
        if(!departmentName.equals("") || !departmentName.equals(this.departmentName)){
            this.departmentName = departmentName;
        }
        else{
            throw new IllegalArgumentException("DepartmentName cant be the same or null");
        }
    }


    public HashMap<String,Employee> getEmployees() {
        return employees;
    }

    /**
     * Add employee.
     *
     * @param employee the employee
     * @throws IllegalArgumentException if employee not in hashmap of employees
     */
    public void addEmployee(Employee employee){
        if(!employees.containsKey(employee.getSocialSecurityNumber())){
            employees.put(employee.getSocialSecurityNumber(),employee);
        }
        else throw new IllegalArgumentException("Employee already in list of employees");
    }

    /**
     * Gets patients.
     *
     * @return the patients
     */
    public HashMap<String, Patient> getPatients() {
        return patients;
    }

    /**
     * Add patient.
     *
     * @param patient the patient
     * @throws IllegalArgumentException if patien not in hashmap of patients
     */
    public void addPatient(Patient patient){
        if(!patients.containsKey(patient.getSocialSecurityNumber())){
            patients.put(patient.getSocialSecurityNumber(), patient);
        }
        else throw new IllegalArgumentException("Patient already in the list of patients");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentName, that.departmentName) && Objects.equals(employees, that.employees) && Objects.equals(patients, that.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, employees, patients);
    }

    /**
     * Remove.
     *
     * @param person the person
     * @throws RemoveException the remove exception
     */
    public void remove(Person person) throws RemoveException {
            if (person instanceof Employee && employees.containsKey(person.getSocialSecurityNumber())) {
                employees.remove(person.getSocialSecurityNumber());
            } else if (person instanceof Patient && patients.containsKey(person.getSocialSecurityNumber())) {
                patients.remove(person.getSocialSecurityNumber());
            }
            else{
                throw new RemoveException("Exception meet when removing person or employee");
            }


        }



    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", employees=" + employees +
                ", patiens=" + patients +
                '}';
    }
}
