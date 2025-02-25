package org.example;

import com.opencsv.CSVReader;
import java.io.*;
import java.util.Scanner;

public class SearchRecord{
    public static void main(String[] args) {
        String filePath = "CSVTestFile.csv";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter EMP Name to Search:");
        String searchEmp = sc.next();

        try (CSVReader csv = new CSVReader(new FileReader(filePath))) {
            csv.readNext(); // Skip header row
            String[] data;
            boolean found = false;
            while ((data = csv.readNext()) != null) {
                if(data[1].equals(searchEmp)) {
                    System.out.println(data[0] + " " + data[1] + " " + data[2] + " " + data[3] + " " + data[4]);
                    found = true;
                    break;
                }
            }
            if(!found)
                System.out.println("EMP Not Found");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}