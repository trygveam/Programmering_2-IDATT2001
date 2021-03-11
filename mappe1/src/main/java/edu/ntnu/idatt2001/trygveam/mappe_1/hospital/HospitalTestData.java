package edu.ntnu.idatt2001.trygveam.mappe_1.hospital;

import edu.ntnu.idatt2001.trygveam.mappe_1.hospital.healthpersonal.GeneralPractitioner;
import edu.ntnu.idatt2001.trygveam.mappe_1.hospital.healthpersonal.Nurse;
import edu.ntnu.idatt2001.trygveam.mappe_1.hospital.healthpersonal.Surgeon;

public class HospitalTestData {
    /**
     * @param hospital
     */
    public static void fillRegisterWithTestData(final Hospital hospital) {
        // Add some departments
        Department emergency = new Department("Akutten");
        emergency.addEmployee(new Employee("Odd Even", "Primtallet", "1"));
        emergency.addEmployee(new Employee("Huppasahn", "DelFinito", "2"));
        emergency.addEmployee(new Employee("Rigmor", "Mortis", "3"));
        emergency.addEmployee(new GeneralPractitioner("Inco", "Gnito", "4"));
        emergency.addEmployee(new Surgeon("Inco", "Gnito", "5"));
        emergency.addEmployee(new Nurse("Nina", "Teknologi", "6"));
        emergency.addEmployee(new Nurse("Ove", "Ralt", "7"));
        emergency.addPatient(new Patient("Inga", "Lykke", "8"));
        emergency.addPatient(new Patient("Ulrik", "Smål", "9"));
        hospital.getDepartments().add(emergency);
        Department childrenPolyclinic = new Department("Barn poliklinikk");
        childrenPolyclinic.addEmployee(new Employee("Salti", "Kaffen", "10"));
        childrenPolyclinic.addEmployee(new Employee("Nidel V.", "Elvefølger", "11"));
        childrenPolyclinic.addEmployee(new Employee("Anton", "Nym", "12"));
        childrenPolyclinic.addEmployee(new GeneralPractitioner("Gene", "Sis", "13"));
        childrenPolyclinic.addEmployee(new Surgeon("Nanna", "Na", "14"));
        childrenPolyclinic.addEmployee(new Nurse("Nora", "Toriet", "15"));
        childrenPolyclinic.addPatient(new Patient("Hans", "Omvar", "16"));
        childrenPolyclinic.addPatient(new Patient("Laila", "La", "17"));
        childrenPolyclinic.addPatient(new Patient("Jøran", "Drebli", "18"));
        hospital.getDepartments().add(childrenPolyclinic);
    }
}
