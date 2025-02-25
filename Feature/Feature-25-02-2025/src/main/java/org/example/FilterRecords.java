package org.example;

import com.opencsv.CSVReader;
import java.io.*;

public class FilterRecords{
    public static void main(String[] args) {
        String filePath = "CSVTestFile.csv";

        try (CSVReader csv = new CSVReader(new FileReader(filePath))) {
            csv.readNext(); // Skip header row
            String[] data;
            while ((data = csv.readNext()) != null) {
                if(Integer.parseInt(data[4])>=80)
                    System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]+" "+data[4]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}