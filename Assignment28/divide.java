import java.util.*;
public class divide{
    public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
         try{
             System.out.println("enter first no");
             int a=sc.nextInt();
             System.out.println("enter second no");
             int b=sc.nextInt();
             int res=a/b;
             System.out.println(res);
         }catch(ArithmeticException e){
             System.out.println("division by zero not allowed");
         }catch(InputMismatchException e){
             System.out.println("invalid input");
         }
    }
}
