package edu.ntnu.idatt2001.trygveam.mappe_1.hospital;

import java.util.ArrayList;

/**
 * The type Hospital.
 * @author trygveam
 */
public class Hospital {
    private ArrayList<Department> departments;
    private String hospitalName;

    /**
     * Instantiates a new Hospital.
     *
     * @param hospitalName the hospital name
     */
    public Hospital(String hospitalName) {
        this.hospitalName =  hospitalName;
        this.departments = new ArrayList<>();
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    /**
     * Add department.
     *
     * @param department the department
     * @throws IllegalArgumentException if department already is in list of departments
     */
    public void addDepartment(Department department){
        if(!departments.contains(department)){
            departments.add(department);
        }
        else{
            throw new IllegalArgumentException("Department already in list of departments");
        }
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "departments=" + departments +
                ", hospitalName='" + hospitalName + '\'' +
                '}';
    }

}
