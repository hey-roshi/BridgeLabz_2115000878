import java.util.*;

// Abstract class Vehicle
abstract class Vehicle {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;
    
    public Vehicle(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    
    public int getVehicleId() {
        return vehicleId;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public double getRatePerKm() {
        return ratePerKm;
    }
    
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: $" + ratePerKm);
    }
    
    public abstract double calculateFare(double distance);
}

// GPS Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Car class
class Car extends Vehicle implements GPS {
    private String location;
    
    public Car(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
    
    @Override
    public String getCurrentLocation() {
        return location;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Bike class
class Bike extends Vehicle implements GPS {
    private String location;
    
    public Bike(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.9; // 10% discount for bikes
    }
    
    @Override
    public String getCurrentLocation() {
        return location;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Auto class
class Auto extends Vehicle implements GPS {
    private String location;
    
    public Auto(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 1.1; // 10% extra for autos
    }
    
    @Override
    public String getCurrentLocation() {
        return location;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Ride-Hailing Application
public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car(101, "Alice", 5.0));
        vehicles.add(new Bike(102, "Bob", 3.0));
        vehicles.add(new Auto(103, "Charlie", 4.0));
        
        double distance = 10; // Example distance
        
        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            double fare = vehicle.calculateFare(distance);
            System.out.println("Calculated Fare for " + distance + " km: $" + fare);
            System.out.println("------------------------");
        }
    }
}
