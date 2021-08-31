package edu.ntnu.idatt2001.trygveam.mappe_2;

import edu.ntnu.idatt2001.trygveam.mappe_2.core.Patient;
import edu.ntnu.idatt2001.trygveam.mappe_2.core.PatientRegister;
import java.io.*;
import java.util.ArrayList;

/**
 * @author trygveam
 * The type Filehandler.
 */
public class Filehandler{


    /**
     * Read from file method, Taking in file and throws IOException if not possible to read
     *
     * @param file the file
     * @return the array list
     * @throws IOException the io exception
     */
    public static ArrayList<Patient> readFromFile(File file) throws IOException {
        ArrayList<Patient> patients = new ArrayList<>();
        // Using bufferedReader with fileReader to load file.
        BufferedReader br = new BufferedReader(new FileReader(file));
            // skipping first line, since its only column information
            String line;
            while ((line = br.readLine()) != null) {
                // Splitting elements on ; making a list of information of each patient.
                String[] arg = line.split(";");
                // Checking for correct length on socialSecurityNumber
                if(arg[3].length() ==11){
                    patients.add(new Patient(arg[3], arg[0], arg[1], "diagnosis", arg[2]));
                }
            }
        // Closing BufferedReader
        br.close();
        // Returning list of imported Patients
        return patients;
    }

    /**
     * Load to file method for export of Patients, taking in current patientregister and filename.
     *
     * @param file            the file
     * @param patientRegister the patient register
     * @throws IOException the io exception
     */
    public static void loadToFile(File file, PatientRegister patientRegister) throws IOException {
       // Using bufferedWriter with fileWriter.
       BufferedWriter bw = new BufferedWriter(new FileWriter(file));
       // Adding line of column information.
       bw.write("firstName;lastNam;generalPractitioner;socialSecurityNumber;\n");
       // looping through every patient in list, writing to file.
       for(Patient p: patientRegister.getPatients()){
           bw.write(p.getFirstName() + ";" + p.getLastName() + ";" +p.getGeneralPractitioner() + ";" +p.getSocialSecurityNumber() + ";\n");
       }
       // Closing bufferedWriter.
       bw.close();
    }



}
