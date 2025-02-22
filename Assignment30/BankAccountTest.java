import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {
    @Test
    void testDeposit() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount account = new BankAccount(200);
        account.withdraw(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount(50);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(100));
        assertEquals("Insufficient funds", exception.getMessage());
    }

    @Test
    void testNegativeDeposit() {
        BankAccount account = new BankAccount(100);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));
        assertEquals("Deposit amount must be positive", exception.getMessage());
    }
}
