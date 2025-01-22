import java.util.*;
public class displayResult{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int firstNo=sc.nextInt();
        int secondNo=sc.nextInt();
        int quotient=firstNo/secondNo;
        int remainder=firstNo%secondNo;
         System.out.println("The Quotient is " + quotient + " and Remainder is "+ remainder + " of the two numbers " + firstNo + " and " + secondNo);

    }
}
