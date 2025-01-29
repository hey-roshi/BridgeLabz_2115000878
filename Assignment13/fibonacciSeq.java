import java.util.*;
public class fibonacciSeq{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int num=sc.nextInt();  
        generateSequence(num);
    }
    private static void generateSequence(int num) {
        int first = 0, second = 1;
        System.out.println("Fibonacci sequence up to " + num + " terms:");

        for (int i = 1; i <= num; i++) {
            System.out.print(first + " ");
            int nextTerm = first + second;
            first = second;
            second = nextTerm;
        }
        System.out.println();
    }
}

