public class Vehicle{
   int maxSpeed;
   String fuelType;
   public Vehicle(int maxSpeed,String fuelType){
       this.maxSpeed=maxSpeed;
       this.fuelType=fuelType;
   }
   public void displayInfo(){
       System.out.println("The max speed is: "+maxSpeed);
       System.out.println("The fuel type is: "+fuelType);
   }
   public static void main(String args[]){
       Vehicle obj1=new Car(90,"petro","maruti",05);
       obj1.displayInfo();
   }
}
class Car extends Vehicle{
   String carName;
   int capacity;
   public Car(int maxSpeed, String fuelType, String carName, int capacity){
       super(maxSpeed, fuelType);
       this.carName=carName;
       this.capacity=capacity;
   }
   public void displayInfo(){
       System.out.println("The max speed is: "+maxSpeed);
       System.out.println("The fuel type is: "+fuelType);
       System.out.println("The car name is: "+carName);
       System.out.println("The capacity is: "+capacity);

   }

}
class Truck extends Vehicle{ 
   int capacity;
   public Truck(int maxSpeed, String fuelType, int capacity){
       super(maxSpeed,fuelType);
       this.capacity=capacity;
   }
   public void displayInfo(){
       System.out.println("The max speed is: "+maxSpeed);
       System.out.println("The fuel type is: "+fuelType);
       System.out.println("The capacity is: "+capacity);
   }
   
}
class Motorcycle extends Vehicle{
   String bikeName;
   int bikeNo;
   public Motorcycle(int maxSpeed, String fuelType, String bikeName, int bikeNo){
       super(maxSpeed,fuelType);
       this.bikeName=bikeName;
       this.bikeNo=bikeNo;
   }
   public void displayInfo(){
       System.out.println("The max speed is: "+maxSpeed);
       System.out.println("The fuel type is: "+fuelType);
       System.out.println("The bikeName is: "+bikeName);
       System.out.println("The bikeNo is: "+bikeNo);
   }

}
