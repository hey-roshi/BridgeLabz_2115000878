import java.util.*;
public class carRental{
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate;
    // Default Constructor
    public carRental(){
        this.customerName = "Unknown";
        this.carModel = "Not Specified";
        this.rentalDays = 0;
        this.dailyRate = 50.0; // Default rate per day
    }
    // Parameterized Constructor
    public carRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }
    // Method to calculate total rental cost
    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }
    // Method to display rental details
    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: $" + dailyRate);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Using default constructor
        carRental rental1 = new carRental();
        System.out.println("Default Rental Details:");
        rental1.displayRentalDetails();
        System.out.println("\n");
        System.out.println("Enter customer name");
        String customer=sc.nextLine();
         System.out.println("Enter car model");
        String carM=sc.nextLine();
         System.out.println("Enter rental days");
        int rentDays=sc.nextInt();
        System.out.println("Enter daily rate");
        double dailyR=sc.nextDouble();

        // Using parameterized constructor
        carRental rental2 = new carRental(customer,carM,rentDays,dailyR);
        System.out.println("Customer Rental Details:");
        rental2.displayRentalDetails();
    }
}










