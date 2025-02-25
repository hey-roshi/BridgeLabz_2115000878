package org.example;

import java.io.*;
import com.opencsv.CSVReader;

public class ReadCSVFile {
    public static void main(String[] args){
        String path = "CSVTestFile.csv";
        try(CSVReader csv = new CSVReader(new FileReader(path))){
            String[] data;
            while ((data = csv.readNext()) != null){
                System.out.println(data[0]+" "+data[1]+" "+data[2]+" "+data[3]);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
