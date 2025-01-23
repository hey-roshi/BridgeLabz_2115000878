import java.util.*;
public class leapYearr{
    public static void main(String args[]){ 
        Scanner sc=new Scanner(System.in);
        int year=sc.nextInt();
        if (year < 1582) {
            System.out.println("The year is before the Gregorian calendar was introduced.");
        }

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year+" is a Leap Year.");
                } else {
                    System.out.println(year+" is NOT a Leap Year.");
                }
            } else {
                    System.out.println(year+" is a Leap Year.");
            }
        } else {
              System.out.println(year+" is NOT a Leap Year.");
        }
     }
}
