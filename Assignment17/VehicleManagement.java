import java.util.Scanner;
class Vehicle{
    static double registrationFee=5000.0;
    final String registrationNumber;
    String ownerName;
    String vehicleType;
    public Vehicle(String ownerName, String vehicleType, String registrationNumber){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    static void updateRegistrationFee(double newFee){
        registrationFee = newFee;
    }
    void displayDetails(){
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
    }
}
public class VehicleManagement{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter owner name: ");
        String ownerName = scanner.nextLine();
        
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();
        
        System.out.print("Enter registration number: ");
        String registrationNumber = scanner.nextLine();
        
        Vehicle vehicle = new Vehicle(ownerName, vehicleType, registrationNumber);
        if(vehicle instanceof Vehicle){
           vehicle.displayDetails();
        }
    }
}
