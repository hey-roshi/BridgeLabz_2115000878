import java.util.*;
public class isPrimeNo{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number:");
        int num=sc.nextInt();
        if(isPrime(num)){
            System.out.println(num + " is a prime number.");
        }else{
            System.out.println(num + " is not a prime number.");
        }
    }
    private static boolean isPrime(int num){
        if(num<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}

