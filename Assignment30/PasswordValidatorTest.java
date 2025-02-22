import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {
    private final PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValidPassword("StrongP@ss1"));
    }

    @Test
    void testShortPassword() {
        assertFalse(validator.isValidPassword("Short1"));
    }

    @Test
    void testMissingUppercase() {
        assertFalse(validator.isValidPassword("weakpassword1"));
    }

    @Test
    void testMissingDigit() {
        assertFalse(validator.isValidPassword("NoDigitHere"));
    }
}
