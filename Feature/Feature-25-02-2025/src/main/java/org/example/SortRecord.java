package org.example;

import com.opencsv.CSVReader;
import java.io.*;
import java.util.*;

public class SortRecord{
    public static void main(String[] args) {
        String filePath = "CSVTestFile.csv";
        List<String[]> al;

        try (CSVReader csv = new CSVReader(new FileReader(filePath))) {
            al = csv.readAll();
            al.remove(0);

            al.sort((a, b) -> Double.compare(Double.parseDouble(b[3]), Double.parseDouble(a[3])));
            System.out.println("Top 5 Highest-Paid Employees:");
            for (int i = 0; i < Math.min(5, al.size()); i++)
                System.out.println(al.get(i)[0]+" " +al.get(i)[1]+" " +al.get(i)[2]+" " +al.get(i)[3]+" " +al.get(i)[4]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}