import java.io.*;

public class upperToLowerConverter{
    public static void main(String[] args) {
        String inputFile = "input.txt";   // Source file
        String outputFile = "output.txt"; // Destination file

        convertUpperToLower(inputFile, outputFile);
    }

    private static void convertUpperToLower(String inputFile, String outputFile) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase()); // Convert to lowercase
                writer.newLine(); // Maintain line breaks
            }

            System.out.println("Conversion completed! Check " + outputFile);
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
