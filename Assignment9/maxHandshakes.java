import java.util.*;
public class maxHandshakes{
    public static void main(String args[]){
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter number of students:");
      int n=sc.nextInt();
      int ans=calculateMaxHandshakes(n);
      System.out.println("The maximum number of handshakes among N number of students is "+ans);    
    }
    public static int calculateMaxHandshakes(int n){
       int ans=(n*(n-1))/2;
       return ans;
    }
}
