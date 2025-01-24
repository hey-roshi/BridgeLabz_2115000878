import java.util.*;
public class meanOfHeights{
    public static void main(String[] args){
        double[] height=new double[11];
        double sum=0.0;
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the heights of players (in cm):");
        for(int i=0;i<height.length;i++){
            System.out.print("Player " + (i + 1) + ": ");
            height[i]=sc.nextDouble();
            sum+=height[i];
        }
        // Calculate the mean of height
        double mean=sum / height.length;
        System.out.print("The mean height of the football team players is : " + mean);

    }
}
