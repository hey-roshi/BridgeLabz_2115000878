import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;

public class FileProcessorTest {
    private final FileProcessor processor = new FileProcessor();
    private final String filename = "testFile.txt";

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello, World!";
        processor.writeToFile(filename, content);
        assertEquals(content, processor.readFromFile(filename));
    }

    @Test
    void testFileExistsAfterWriting() throws IOException {
        processor.writeToFile(filename, "Test Data");
        File file = new File(filename);
        assertTrue(file.exists());
    }
}
