import java.util.*;
public class oddEvenArray{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number=sc.nextInt();
        // Check if the number is a natural number or not
        if(number<=0){
            System.out.println("Please enter a natural number.");
            return;
        }
        int size=number/2+1;
        int[] oddNumber=new int[size];
        int[] evenNumber=new int[size];
        int oddIndex=0,evenIndex=0;
        for(int i=1;i<=number;i++){
            if(i%2==0){
                evenNumber[evenIndex]=i;
                evenIndex++;
            }else{
                oddNumber[oddIndex] = i;
                oddIndex++;
            }
        }
        System.out.println("Odd numbers:");
        for(int i=0;i<oddIndex;i++){
            System.out.print(oddNumber[i] + " ");
        }
        System.out.println();
        System.out.println("Even numbers:");
        for(int i=0;i<evenIndex;i++){
            System.out.print(evenNumber[i] + " ");
        }
        System.out.println();
    }
}
