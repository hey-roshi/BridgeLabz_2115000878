package org.example;

import com.opencsv.*;
import java.io.*;
import java.util.*;

public class MergeTwoCSVFiles {
    public static void main(String[] args) throws Exception{
        HashMap<String, String[]> hm = new HashMap<>();
        try(CSVReader csv = new CSVReader(new FileReader("students1.csv"))){
            csv.readNext();
            for(String[] row: csv.readAll())
                hm.put(row[0],row);
        }
        try(CSVReader csv = new CSVReader(new FileReader("students2.csv"))){
            csv.readNext();
            for(String[] row: csv.readAll())
                if(hm.containsKey(row[0]))
                    hm.put(row[0], new String[]{row[0],hm.get(row[0])[1], hm.get(row[0])[2], row[1], row[2]});
        }
        try(CSVWriter csv = new CSVWriter(new FileWriter("MergedFiled.csv"))){
            csv.writeNext(new String[]{"ID", "Name", "Age", "Marks", "Grade"});
            for(String[] row : hm.values())
                csv.writeNext(row);
        }
        System.out.println("DONE");
    }
}
