package org.example;

import com.opencsv.CSVReader;
import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) throws Exception {
        String filePath = "large_dataset.csv";
        int batchSize = 100;
        int totalRecords = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext();
            String[] data;
            int batchCount = 0;

            while ((data = reader.readNext()) != null) {
                totalRecords++;
                batchCount++;

                System.out.println("Processing: ID=" + data[0] + ", Name=" + data[1]);

                if (batchCount == batchSize) {
                    System.out.println("✅ Processed " + batchSize + " records...");
                    batchCount = 0;
                }
            }

            System.out.println("✅ Total records processed: " + totalRecords);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
