import java.util.Scanner;
public class calculateBMI{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // Input the number of persons
        System.out.print("Enter the number of persons: ");
        int numPersons=sc.nextInt();
        // Declare arrays to store height, weight, BMI, and status
        double[] heights=new double[numPersons];
        double[] weights=new double[numPersons];
        double[] bmis=new double[numPersons];
        String[] statuses=new String[numPersons];
        // Input weight and height for each person
        for(int i=0;i<numPersons;i++){
            System.out.println("Enter details for person " + (i + 1) + ":");
            System.out.print("Enter height (in meters): ");
            heights[i]=sc.nextDouble();
            System.out.print("Enter weight (in kg): ");
            weights[i]=sc.nextDouble();
        }
        // Calculate BMI and determine status
        for(int i=0;i<numPersons;i++){
            bmis[i]=weights[i]/(heights[i]*heights[i]);
            // Determine weight status based on BMI
            if(bmis[i]<18.5){
                statuses[i]="Underweight";
            }else if(bmis[i] >= 18.5 && bmis[i] < 24.9) {
                statuses[i] = "Normal weight";
            }else if(bmis[i] >= 25 && bmis[i] < 29.9) {
                statuses[i] = "Overweight";
            }else{
                statuses[i] = "Obese";
            }
        }
        // Display results
        System.out.println("\nResults:");
        System.out.println("Person\tHeight (m)\tWeight (kg)\tBMI\t\tStatus");
 
        // Loop through each person and print their details
        for (int i = 0; i < numPersons; i++) {
           System.out.println((i + 1) + "\t" 
            + heights[i] + "\t\t" 
            + weights[i] + "\t\t" 
            + bmis[i] + "\t" 
            + statuses[i]);
        }
    }
}
