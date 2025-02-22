import java.util.Scanner;
public class licensePlateValidator {
    private static final String LICENSE_PLATE_PATTERN = "^[A-Z]{2}\\d{4}$";
    public static boolean isValidLicensePlate(String plate) {
        return plate.matches(LICENSE_PLATE_PATTERN);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a license plate number: ");
        String plate = scanner.nextLine();
        if (isValidLicensePlate(plate)) {
            System.out.println("✅ Valid license plate");
        } else {
            System.out.println("❌ Invalid license plate");
        }
    }
}
