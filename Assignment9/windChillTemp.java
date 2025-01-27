import java.util.*;
public class windChillTemp{
    public static void main(String args[]){
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the temp:");
       double temp=sc.nextDouble();
       System.out.println("Enter the windspeed:");
       double windSpeed=sc.nextDouble();
       double ans=calculateWindChill(temp,windSpeed);
       System.out.println(ans);
    }
    public static double calculateWindChill(double temp, double windSpeed){
       double ans= 35.74 + 0.6215 *temp + (0.4275*temp - 35.75) * (Math.pow(windSpeed,0.16)); 
       return ans;

    }
}
