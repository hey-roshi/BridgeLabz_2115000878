import java.util.*;
public class reverseString{
      public static void main(String args[]){
           Scanner sc=new Scanner(System.in);              
           String str=sc.nextLine();
           StringBuilder sb=new StringBuilder(str);
           sb.reverse();
           System.out.println(sb.toString());
      }
}
