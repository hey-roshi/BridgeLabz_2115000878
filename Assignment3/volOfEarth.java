public class volOfEarth{
public static void main(String[] args) {
double radius = 6378;
double kmToMiles = 0.621371; //Conversion factor
double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);//formula
double volumeMiles3 = volumeKm3 * Math.pow(kmToMiles, 3);
System.out.println("The volume of Earth in cubic kilometers is "+volumeKm3);
System.out.println("The volume of Earth in cubic miles is " +volumeMiles3);
   }
}
