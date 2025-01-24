import java.util.*;
public class eligibleForVoting{
  public static void main(String[] args){
        // Define an array to store the age of 10 students
        int[] studentAges=new int[10];
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the age of 10 students:");

        for(int i=0;i<studentAges.length;i++){
            System.out.print("Student "+(i+1)+": ");
            studentAges[i]=sc.nextInt();
        }

        // Check voting eligibility for each and every student
        for(int i=0;i<studentAges.length;i++){
            if(studentAges[i]<0){
                System.out.println("Invalid age entered for student " + (i + 1) + ".");
            }else if(studentAges[i]>=18){
                System.out.println("The student with the age " + studentAges[i] + " can vote.");
            }else{
                System.out.println("The student with the age " + studentAges[i] + " cannot vote.");
            }
        }
    }
}
