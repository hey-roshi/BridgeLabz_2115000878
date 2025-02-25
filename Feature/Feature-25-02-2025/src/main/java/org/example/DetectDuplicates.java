package org.example;

import java.util.*;
import com.opencsv.*;
import java.io.*;

public class DetectDuplicates {
    public static void main(String[] args) throws Exception {
        HashSet<String> hm = new HashSet<>();
        try(CSVReader csv = new CSVReader(new FileReader("MergedFiled.csv"))){
            csv.readNext();
            for(String[] row : csv.readAll()) {
                if (hm.contains(row[0]))
                    System.out.println(row[0] + " " + row[1] + " " + row[2]);
                hm.add(row[0]);
            }
        }
    }
}
