import java.util.*;
public class maxHandshakes{
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter number of students :" );
        int numberOfStudents = sc.nextInt();
        if (numberOfStudents < 2){
            System.out.print("Possible number of handshakes should be 2");
        }
        else{
            int noOfHandshakes = (numberOfStudents * (numberOfStudents - 1))/2;
            System.out.println("Total handshakes is: " + noOfHandshakes);
        }
    }
}

