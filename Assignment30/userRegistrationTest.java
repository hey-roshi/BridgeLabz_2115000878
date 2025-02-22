import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class userRegistrationTest {
    private final UserRegistration registration = new UserRegistration();

    @Test
    void testValidRegistration() {
        assertDoesNotThrow(() -> registration.registerUser("JohnDoe", "john@example.com", "Secure123"));
    }

    @Test
    void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> registration.registerUser("", "john@example.com", "Secure123"));
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    @Test
    void testInvalidEmail() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> registration.registerUser("JohnDoe", "invalid-email", "Secure123"));
        assertEquals("Invalid email format", exception.getMessage());
    }

    @Test
    void testShortPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> registration.registerUser("JohnDoe", "john@example.com", "123"));
