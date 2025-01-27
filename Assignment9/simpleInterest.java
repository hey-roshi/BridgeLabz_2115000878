import java.util.*;
public class simpleInterest{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the principle:");
        double principle=sc.nextInt();
        System.out.println("Enter the rate:");
        double rate=sc.nextInt();
        System.out.println("Enter the time:");
        double time=sc.nextInt();
        double ans=calculateSI(principle, rate,time);
        System.out.println("The simple interest is "+ans);
    }
    public static double calculateSI(double P,double R,double T){
        double ans=(P*R*T)/100;
        return ans;
    }
}
