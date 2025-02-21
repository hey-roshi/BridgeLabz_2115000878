import java.io.*;
import java.util.*;

public class wordFrequencyCounter{
    public static void main(String[] args) {
        String fileName = "textfile.txt"; // Replace with your file

        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

            // Sort by frequency (descending)
            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
            sortedWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            // Print top 5 most frequent words
            System.out.println("Top 5 Most Frequent Words:");
            int count = 0;
            for (Map.Entry<String, Integer> entry : sortedWords) {
                if (count++ == 5) break;
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
