import java.io.*;

public class userInputToFile{
    public static void main(String[] args) {
        String fileName = "user_data.txt"; // Output file

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(fileName)) {

            // Read user input
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            int age = Integer.parseInt(reader.readLine()); // Convert to integer

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            // Write to file
            writer.write("Name: " + name + "\n");
            writer.write("Age: " + age + "\n");
            writer.write("Favorite Programming Language: " + language + "\n");

            System.out.println("User data saved successfully to " + fileName);

        } catch (IOException e) {
            System.out.println("Error reading/writing file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age! Please enter a valid number.");
        }
    }
}
