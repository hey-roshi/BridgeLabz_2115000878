import java.io.*;
public class largeReadingFileComparison{
    static final String FILE_PATH = "largefile.txt";
    public static void testFileReader() {
        long startTime = System.nanoTime();
        try (FileReader fr = new FileReader(FILE_PATH)) {
            while (fr.read() != -1) {
                // Reading character by character
            }
        } catch (IOException e) {
            System.out.println("Error using FileReader: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        System.out.println("FileReader Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Method to read file using InputStreamReader
    public static void testInputStreamReader() {
        long startTime = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(FILE_PATH))) {
            while (isr.read() != -1) {
                // Reading byte by byte and converting to character
            }
        } catch (IOException e) {
            System.out.println("Error using InputStreamReader: " + e.getMessage());
        }
        long endTime = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static void main(String[] args) {
        System.out.println("Reading a Large File (500MB)...");
        testFileReader();
        testInputStreamReader();
    }
}
