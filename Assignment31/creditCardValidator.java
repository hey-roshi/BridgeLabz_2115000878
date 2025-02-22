import java.util.regex.*;

public class creditCardValidator {
    public static boolean isValidCreditCard(String card) {
        return card.matches("^(4\\d{15}|5[1-5]\\d{14})$");
    }

    public static void main(String[] args) {
        System.out.println(isValidCreditCard("4111111111111111")); // Visa (true)
        System.out.println(isValidCreditCard("5111111111111111")); // MasterCard (true)
        System.out.println(isValidCreditCard("6111111111111111")); // false
    }
}
