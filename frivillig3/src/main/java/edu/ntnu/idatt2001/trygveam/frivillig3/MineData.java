package edu.ntnu.idatt2001.trygveam.frivillig3;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MineData {

    public int readFileCountLines(String filename) throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();
            // could be necessary to check if the lines are empty to not count empty lines.
            // if(reader.readline().lenght() >0) etc.
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean readAndWriteToFileUTF8(String readFilename, String writeFilename) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(readFilename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(writeFilename));
            String s = reader.readLine();
            while (s != null) {
                writer.write(s.toUpperCase());
                writer.newLine();
                s = reader.readLine();
            }
            reader.close();
            writer.flush();
            writer.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean readAndWriteToFileUTF16(String readFilename, String writeFilename) throws IOException {
        try {
            InputStream in = new FileInputStream(readFilename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_16));
            BufferedWriter writer = new BufferedWriter(new FileWriter(writeFilename));
            String line = reader.readLine();
            while (line != null) {
                writer.write(line);
                writer.newLine();
                line = reader.readLine();
            }
            reader.close();
            writer.flush();
            writer.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<String> readFileAddParagraph(String readFilename) throws FileNotFoundException {
        try {
            List<String> paragrahps = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(readFilename));
            String line = reader.readLine();
            while (line.length() == 0) {
                line = reader.readLine();
            }
            String p = "";
            while (line != null) {
                p += line;
                line = reader.readLine();
                if (line != null) {
                    if (line.length() == 0) {
                        paragrahps.add(p);
                        p = "";
                    }
                } else {
                    paragrahps.add(p);
                    p = "";
                }
            }
            return paragrahps;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void serializeAndDeserialize(Serializable object, String filename) {
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);
            out.close();
            file.close();
            System.out.println(object);
            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
        Paragrafer object1;
        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (Paragrafer) in.readObject();
            in.close();
            file.close();
            System.out.println("Object has been deserialized ");
            System.out.println(object1.toString());
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

    }


    public static void main(String[] args) throws Exception {
        MineData md = new MineData();
        // Task to read content from minedata.txt located under resources
        //System.out.println(md.readFileCountLines("src/main/resources/minedata.txt"));

        // Task to read and write from file minedata-utf8.txt to dinedata.txt
        //System.out.println(md.readAndWriteToFileUTF8("src/main/resources/minedata-utf8.txt","src/main/resources/dineData.txt"));

        // Method to read and write from file minedata-utf16.txt to dinedata.txt
        //System.out.println(md.readAndWriteToFileUTF16("src/main/resources/minedata-utf16.txt","src/main/resources/dineData.txt"));


        Paragrafer pg = new Paragrafer(md.readFileAddParagraph("src/main/resources/minedata-utf8.txt"));
        System.out.println(pg.toString());

        md.serializeAndDeserialize(pg, "paragraphs.ser");
    }
}
