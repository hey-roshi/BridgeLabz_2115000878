package org.example;

import com.opencsv.CSVReader;
import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "CSVTestFile.csv";
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (CSVReader csv = new CSVReader(new FileReader(filePath))) {
            csv.readNext(); // Skip header
            String[] data;
            while ((data = csv.readNext()) != null) {
                String email = data[5];
                String phone = data[6];

                if (!emailPattern.matcher(email).matches())
                    System.out.println("Invalid email: " + email);

                if (!phonePattern.matcher(phone).matches())
                    System.out.println("Invalid phone: " + phone);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
