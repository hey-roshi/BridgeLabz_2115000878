import java.util.Scanner;
class HotelBookingSystem{
   String guestName;
   String roomType;
   int nights;
   // Default Constructor
   public HotelBookingSystem(){
       this.guestName = "Unknown";
       this.roomType = "Standard";
       this.nights = 1;
   }
   // Parameterized Constructor
   public HotelBookingSystem(String guestName, String roomType, int nights){
       this.guestName = guestName;
       this.roomType = roomType;
       this.nights = nights;
   }
   // Copy Constructor
   public HotelBookingSystem(HotelBookingSystem other) {
       this.guestName = other.guestName;
       this.roomType = other.roomType;
       this.nights = other.nights;
   }
   // Method to display booking details
   public void displayBooking() {
       System.out.println("Guest Name: " + guestName);
       System.out.println("Room Type: " + roomType);
       System.out.println("Nights: " + nights);
   }
   public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       System.out.print("Enter Guest Name: ");
       String name = sc.nextLine();
       System.out.print("Enter Room Type: ");
       String roomType = sc.nextLine();
      
       System.out.print("Enter Number of Nights: ");
       int nights = sc.nextInt();
      
       // Creating booking using parameterized constructor
       HotelBookingSystem booking1 = new HotelBookingSystem(name, roomType, nights);
      
       // Creating a copy of booking1
       HotelBookingSystem booking2 = new HotelBookingSystem(booking1);
      
       System.out.println("\nBooking Details:");
       booking1.displayBooking();
      
       System.out.println("\nCopied Booking Details:");
       booking2.displayBooking();
   }
}


