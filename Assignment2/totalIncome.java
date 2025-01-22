import java.util.*;
public class totalIncome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // Taking input for salary
        System.out.print("Enter the salary: ");
        double salary=sc.nextDouble();

        // Taking input for bonus
        System.out.print("Enter the bonus: ");
        double bonus=sc.nextDouble();

        // Calculating total income
        double totalIncome=salary+bonus;

        // Displaying the result
        System.out.println("The salary is " + salary + " and bonus is " + bonus +
                           ". Hence Total Income is " + totalIncome);
    }
}
