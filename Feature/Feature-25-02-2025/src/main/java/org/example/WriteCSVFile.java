package org.example;

import com.opencsv.CSVWriter;
import java.io.*;

public class WriteCSVFile{
    public static void main(String[] args) {
        String filePath = "CSVTestFile.csv";

        try (CSVWriter csv = new CSVWriter(new FileWriter(filePath))) {
            String[] heading = {"ID", "Name", "Department", "Salary", "Marks", "Email","Phone"};
            csv.writeNext(heading);

            String[][] data = {
                {"2115", "Ayush", "IT", "80000","90", "abc@gmail.com", "147258369"},
                {"2116", "Kunal", "IT", "40000", "65", "abcgmail.com", "147258369"},
                {"2117", "Anuj", "Marketing", "60000", "80", "abc@gmail.com", "14725869"},
                {"2118", "Vikas", "Marketing", "50000", "75", "abc@gmail.com", "147258369"},
                {"2119", "Jatin", "IT", "20000", "85", "abc@gmail.com", "147258369"}
            };

            for (String[] d : data) {
                csv.writeNext(d);
            }

            System.out.println("DONE.");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
