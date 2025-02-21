import java.io.*;
import java.nio.file.Files;

public class imageByteArray{
    public static void main(String[] args) {
        String sourceImage = "source.jpg";  // Replace with your image file
        String outputImage = "copy.jpg";    // Output file name

        // Convert image to byte array
        byte[] imageData = imageToByteArray(sourceImage);
        if (imageData != null) {
            System.out.println("Image converted to byte array successfully!");
            
            // Convert byte array back to image
            if (byteArrayToImage(imageData, outputImage)) {
                System.out.println("Image successfully written to: " + outputImage);
            }
        }
    }

    // Method to convert an image to a byte array
    private static byte[] imageToByteArray(String imagePath) {
        try (FileInputStream fis = new FileInputStream(imagePath);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            System.out.println("Error converting image to byte array: " + e.getMessage());
            return null;
        }
    }

    // Method to convert a byte array back to an image
    private static boolean byteArrayToImage(byte[] imageData, String outputPath) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error writing byte array to image: " + e.getMessage());
            return false;
        }
    }
}
