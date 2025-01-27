import java.util.*;
public class checkNumber{
     public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
         System.out.println("Enter the number:");
         int number=sc.nextInt();
         int ans=numberCheck(number);
         if(ans==-1){
           System.out.println("The number entered is negative.");
         }else if(ans==1){
           System.out.println("The number entered is positive.");
         }else{
           System.out.println("The number entered is zero.");
         }
     }
     public static int numberCheck(int number){
        if(number<0){
           return -1;
        }else if(number>0){
           return 1;
        }else{
           return 0;
        }
     }
 }
