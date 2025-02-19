import java.io.*;
import java.util.*;

public class wordFreqCounter{
    public static void main(String[] args) {
        String fileName = "input.txt"; // Change this to your file path
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Convert to lowercase and remove punctuation
                line = line.toLowerCase().replaceAll("[^a-z ]", "");
                
                // Split into words
                String[] words = line.split("\\s+");

                // Count frequency
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // Display word frequencies
        System.out.println("Word Frequencies: " + wordCount);
    }
}
