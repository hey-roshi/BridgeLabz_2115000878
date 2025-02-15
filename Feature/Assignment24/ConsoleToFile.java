import java.io.*;
public class ConsoleToFile{
    public static void main(String[] args) {
        String filePath = "user_input.txt"; // File where input will be stored

        try {
            // Step 1: Create InputStreamReader to read from System.in (console)
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);

            // Step 2: Wrap InputStreamReader in BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Step 3: Create FileWriter to write to a file (append mode)
            FileWriter fileWriter = new FileWriter(filePath, true); // true for append mode
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            System.out.println("Enter text (type 'exit' to stop):");

            String userInput;
            while (true) {
                // Step 4: Read user input from console
                userInput = bufferedReader.readLine();

                // Step 5: Check if user wants to exit
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }

                // Step 6: Write input to the file
                bufferedWriter.write(userInput);
                bufferedWriter.newLine(); // Move to the next line
            }

            // Step 7: Close resources
            bufferedWriter.close();
            bufferedReader.close();

            System.out.println("User input has been saved to " + filePath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
