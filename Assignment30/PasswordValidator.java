public class PasswordValidator {
    public boolean isValidPassword(String password) {
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*\\d.*");
    }
}
