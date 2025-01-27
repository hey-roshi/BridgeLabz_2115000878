import java.util.*;
public class distributionOfChocalates{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of chocalates:");
        int numberOfChocalates=sc.nextInt();
        System.out.println("Enter the number of children:");
        int numberOfChildren=sc.nextInt();
        int ans[]=findRemainderAndQuotient(numberOfChocalates,numberOfChildren);
        System.out.println("The number of chocolates each child gets is "+ans[0]+" & the remaining cholacates is "+ans[1]);
    }
    public static int[] findRemainderAndQuotient(int number, int divisor){
         int ans[]=new int[2];
         ans[0]=number/divisor;
         ans[1]=number%divisor;
         return ans;

    }
}
