import java.io.*;
public class bufferedFileCopy {
    public static void main(String[] args) {
        String sourceFile = "largefile.dat";  // Replace with actual file path
        String destBuffered = "buffered_copy.dat";
        String destUnbuffered = "unbuffered_copy.dat";

        // Copy using Buffered Streams
        long bufferedTime = copyUsingBufferedStreams(sourceFile, destBuffered);
        System.out.println("Buffered Streams Copy Time: " + bufferedTime + " ns");

        // Copy using Unbuffered Streams
        long unbufferedTime = copyUsingUnbufferedStreams(sourceFile, destUnbuffered);
        System.out.println("Unbuffered Streams Copy Time: " + unbufferedTime + " ns");
    }

    // Method to copy file using Buffered Streams
    private static long copyUsingBufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error during buffered copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }

    // Method to copy file using Unbuffered Streams
    private static long copyUsingUnbufferedStreams(String source, String destination) {
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
        } catch (IOException e) {
            System.out.println("Error during unbuffered copy: " + e.getMessage());
        }
        return System.nanoTime() - startTime;
    }
}
