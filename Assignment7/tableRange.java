import java.util.*;
public class tableRange{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number=sc.nextInt();
        int[] Table=new int[4];
        for(int i=6;i<= 9;i++){
            Table[i - 6]=number * i;
        }
        System.out.println("Multiplication Table for " + number + " (from 6 to 9):");
        for(int i=6;i<=9;i++){
            System.out.println(number + " * " + i + " = " + Table[i - 6]);
        }
    }
}
