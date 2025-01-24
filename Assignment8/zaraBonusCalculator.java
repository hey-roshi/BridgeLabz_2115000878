import java.util.Scanner;
public class zaraBonusCalculator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int EMPLOYEE_COUNT = 10;
        double[] salary = new double[EMPLOYEE_COUNT];
        double[] yearsOfService = new double[EMPLOYEE_COUNT];
        double[] bonus = new double[EMPLOYEE_COUNT];
        double[] newSalary = new double[EMPLOYEE_COUNT];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Input salary and years of service
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Enter the salary of employee " + (i + 1) + ": ");
            double inputSalary = sc.nextDouble();

            System.out.println("Enter the years of service of employee " + (i + 1) + ": ");
            double inputYears = sc.nextDouble();

            // Validate inputs
            if (inputSalary <= 0 || inputYears < 0) {
                System.out.println("Invalid input. Please enter valid salary and years of service.");
                i--; // Decrement the index to re-enter the values for this employee
                continue;
            }

            salary[i] = inputSalary;
            yearsOfService[i] = inputYears;
        }

        // Calculate bonus, new salary, and totals
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05; // 5% bonus for more than 5 years of service
            } else {
                bonus[i] = salary[i] * 0.02; // 2% bonus for 5 or fewer years of service
            }

            newSalary[i] = salary[i] + bonus[i]; // New salary = old salary + bonus
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Print results
        System.out.println("\nEmployee-wise details:");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.printf("Employee %d: Old Salary = %.2f, Bonus = %.2f, New Salary = %.2f\n",
                    (i + 1), salary[i], bonus[i], newSalary[i]);
        }

        System.out.println("\nSummary:");
        System.out.printf("Total Bonus Payout: %.2f\n", totalBonus);
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);

      
    }
}
