import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {
    private final DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDateConversion() {
        assertEquals("10-02-2025", formatter.formatDate("2025-02-10"));
    }

    @Test
    void testInvalidDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> formatter.formatDate("2025-13-32"));
        assertEquals("Invalid date format", exception.getMessage());
    }

    @Test
    void testEmptyDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> formatter.formatDate(""));
        assertEquals("Invalid date format", exception.getMessage());
    }
}
