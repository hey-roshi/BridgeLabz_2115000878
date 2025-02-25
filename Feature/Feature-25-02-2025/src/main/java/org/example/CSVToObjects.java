package org.example;

import com.opencsv.bean.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class CSVToObjects {
    public static void main(String[] args) {
        String csvFile = "CSVTestFile.csv";

        try (FileReader reader = new FileReader(csvFile)) {
            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
                    .withType(Student.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSkipLines(1)
                    .build();

            List<Student> students = csvToBean.parse();
            students.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
