import java.io.*;

public class ByteToChar{
    public static void main(String[] args) {
        String filePath = "sample.txt"; // File path

        try {
            // Step 1: Create a FileInputStream to read the binary data
            FileInputStream fileInputStream = new FileInputStream(filePath);

            // Step 2: Wrap FileInputStream in InputStreamReader to convert bytes to characters
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

            // Step 3: Wrap InputStreamReader in BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Step 4: Read and print file content line by line
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Step 5: Close resources
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
