import java.util.*;
class InvalidAgeException extends Exception{
     public InvalidAgeException(String message){
         super(message);
     }
}
public class ageChecker{
     public static void validateAge(int age) throws InvalidAgeException{
         if(age<18){
            throw new InvalidAgeException("age must be 18 or above");
         }
         System.out.println("access granted");
     }
     public static void main(String args[]){
         Scanner sc=new Scanner(System.in);
         try{
            System.out.println("enter the age");
            int age=sc.nextInt();
            validateAge(age);
         }catch(InvalidAgeException e){
             System.out.println(e.getMessage());
         }catch(Exception e){
             System.out.println("invalid input");
         }
     }
}
