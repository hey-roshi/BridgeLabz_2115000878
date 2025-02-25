package org.example;

import com.opencsv.*;
import java.io.*;
import java.util.*;

public class ModifyCSV {
    public static void main(String[] args) throws Exception{
        String inputFile = "CSVTestFile.csv";
        String outputFile = "UpdatedCSVTestFile.csv";

        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> rows = reader.readAll();
            writer.writeNext(rows.get(0));

            for (int i = 1; i < rows.size(); i++) {
                String[] data = rows.get(i);
                if ("IT".equalsIgnoreCase(data[2])) {
                    int currentSalary = Integer.parseInt(data[3]);
                    data[3] = String.valueOf((int) (currentSalary * 1.10));
                }
                writer.writeNext(data);
            }

            System.out.println("DONE");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
