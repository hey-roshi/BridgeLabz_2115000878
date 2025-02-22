import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(10, calculator.add(6, 4));
        assertEquals(-3, calculator.add(-1, -2));
        assertEquals(0, calculator.add(5, -5));
    }

    @Test
    public void testSubtraction() {
        assertEquals(2, calculator.subtract(6, 4));
        assertEquals(1, calculator.subtract(-1, -2));
        assertEquals(10, calculator.subtract(5, -5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(24, calculator.multiply(6, 4));
        assertEquals(2, calculator.multiply(-1, -2));
        assertEquals(-25, calculator.multiply(5, -5));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.divide(8, 4));
        assertEquals(-3, calculator.divide(-9, 3));
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
