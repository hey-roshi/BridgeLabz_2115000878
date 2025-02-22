import java.util.Scanner;
public class usernameValidator {
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
    public static boolean isValidUsername(String username) {
        return username.matches(USERNAME_PATTERN);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        if (isValidUsername(username)) {
            System.out.println("✅ Valid username");
        } else {
            System.out.println("❌ Invalid username");
        }
    }
}
