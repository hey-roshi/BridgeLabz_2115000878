import java.util.*;
public class factorsOfNumber{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number=sc.nextInt();
        int maxFactor=10;
        int[] factors=new int[maxFactor];
        int index=0;
        // Find factors of the number
        for(int i=1;i<=number;i++){
            if(number%i==0){
                if(index==maxFactor){
                    // Double the size of the array
                    maxFactor*= 2;
                    int[] temp=new int[maxFactor];
                    // Copy elements from old array to the new array
                    System.arraycopy(factors, 0, temp, 0, factors.length);
                    factors=temp;
                }
                factors[index]=i;
                index++;
            }
        }
        System.out.println("Factors of " + number + ":");
        for(int i=0;i<index;i++){
            System.out.print(factors[i] + " ");
        }
        System.out.println();
   }
}
