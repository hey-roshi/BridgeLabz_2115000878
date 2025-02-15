
import java.io.*;
public class WordCountInFile {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // File path
        String targetWord = "Java"; // Word to count
        int wordCount = 0; // Counter for occurrences
        try {
            // Create FileReader and wrap it with BufferedReader
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // Read each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into words (using whitespace and punctuation)
                String[] words = line.split("\\W+");

                // Check each word and count occurrences of the target word
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) { // Case-insensitive match
                        wordCount++;
                    }
                }
            }
            // Close the BufferedReader
            bufferedReader.close();
            // Print the total occurrences
            System.out.println("The word \"" + targetWord + "\" appears " + wordCount + " times in the file.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

