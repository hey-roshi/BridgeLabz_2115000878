import java.util.*;
public class sumOfNaturalNumbers{
   public static int sumRecursion(int n){
      if(n==1){
         return 1;
      }
      return n+sumRecursion(n-1);
   }
   public static int sumformula(int n){
      return n*(n+1)/2;
   }
   public static void main(String[]args){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the number :");
       int n=sc.nextInt();
       if(n<=0){
         System.out.println("It is not a natural Number");
         return;
       } //comparing the result of sums
       int sum1=sumRecursion(n);
       int sum2=sumformula(n);
       System.out.println("Sum using Recursion: "+sum1);
       System.out.println("Sum using formula: "+sum2);
       if(sum1==sum2){
            System.out.println("Results are same ");
       }else{
            System.out.println("Results are not same ");
       }
    }
}
