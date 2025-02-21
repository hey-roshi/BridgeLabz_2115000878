import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class fileReadWrite{
    public static void main(String[] args) {
        String sourceFile = "source.txt";  // Source file to read from
        String destinationFile = "destination.txt";  // Destination file to write to

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData); // Writing data byte by byte
            }
            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("Error: Source file not found or cannot be read.");
        }
    }
}
