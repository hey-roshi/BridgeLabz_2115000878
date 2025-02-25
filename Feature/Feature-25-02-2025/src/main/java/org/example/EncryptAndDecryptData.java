package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;

public class EncryptAndDecryptData {
    public static void encryption(String mainFilePath, String encryptedFilePath) throws Exception{
        try(CSVReader csvReader = new CSVReader(new FileReader(mainFilePath));
            CSVWriter csvWriter = new CSVWriter(new FileWriter(encryptedFilePath))){
            String[] header = csvReader.readNext();
            csvWriter.writeNext(header);

            String[] data;
            while ((data = csvReader.readNext()) != null){
                data[5] = String.valueOf(Integer.parseInt(data[5]) + 1000);
                data[1] = shiftCharacters(data[1], 2);
                csvWriter.writeNext(data);
            }
            System.out.println("DONE");
        }
    }
    public static void decryption(String encryptedFilePath, String decryptedFilePath) throws Exception{
        try (CSVReader csvReader = new CSVReader(new FileReader(encryptedFilePath));
             CSVWriter csvWriter = new CSVWriter(new FileWriter(decryptedFilePath))) {
            String[] header = csvReader.readNext();
            csvWriter.writeNext(header);

            String[] data;
            while ((data = csvReader.readNext()) != null) {
                data[5] = String.valueOf(Integer.parseInt(data[5]) - 1000);
                data[1] = shiftCharacters(data[1], -2);
                csvWriter.writeNext(data);
            }
            System.out.println("DONE");
        }
    }
    public static String shiftCharacters(String text, int shift) {
        StringBuilder res = new StringBuilder();
        for (char ch : text.toCharArray())
            res.append((char) (ch + shift));
        return res.toString();
    }
    public static void main(String[] args) throws Exception {
        String mainFilePath = "MergedFiled.csv";
        String encryptedFilePath = "encryptedStudents1.csv";
        String decryptedFilePath = "decryptedStudents1.csv";

        encryption(mainFilePath, encryptedFilePath);
        decryption(encryptedFilePath, decryptedFilePath);
    }
}
