import java.util.Scanner;
public class friendsComparison{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] friends={"Amar", "Akbar", "Anthony"};
        int[] ages=new int[3];
        double[] heights=new double[3];
        // Input ages and heights
        for(int i=0;i<3;i++){
            System.out.println("Enter the age of " + friends[i] + ": ");
            ages[i]=sc.nextInt();
            System.out.println("Enter the height (in cm) of " + friends[i] + ": ");
            heights[i]=sc.nextDouble();
        }
        // Find the youngest and the tallest friend
        int youngestIndex=0;
        int minAge=ages[0];
        int tallestIndex=0;
        double maxHeight=heights[0];
        for(int i=1;i<3;i++){
            if(ages[i]<minAge){
                minAge=ages[i];
                youngestIndex=i;
            }
            if (heights[i]>maxHeight){
                maxHeight=heights[i];
                tallestIndex=i;
            }
        }
        // Display results
        System.out.println("Results:");
        System.out.println("The youngest friend is " + friends[youngestIndex] + " with age " + minAge + " years.");
        System.out.println("The tallest friend is " + friends[tallestIndex] + " with height " + maxHeight + " cm.");
    }
}
