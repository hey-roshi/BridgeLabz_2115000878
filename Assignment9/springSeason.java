import java.util.Scanner;

public class springSeason {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the month and day from the user
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter the day (1-31): ");
        int day = scanner.nextInt();

        // Check if it's spring season and print the result
        if (isSpringSeason(month, day)) {
            System.out.println("It's a Spring Season.");
        } else {
            System.out.println("Not a Spring Season.");
        }
    }

    // Method to check if the date falls in the spring season
    public static boolean isSpringSeason(int month, int day) {
        // Check for March
        if (month == 3 && day >= 20 && day <= 31) {
            return true;
        }
        // Check for April
        else if (month == 4 && day >= 1 && day <= 30) {
            return true;
        }
        // Check for May
        else if (month == 5 && day >= 1 && day <= 31) {
            return true;
        }
        // Check for June
        else if (month == 6 && day >= 1 && day <= 20) {
            return true;
        }

        // If not in spring range, return false
        return false;
    }
}
