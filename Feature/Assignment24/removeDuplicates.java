import java.util.*;
public class removeDuplicates{
      public static void main(String args[]){
          Scanner sc=new Scanner(System.in);
          String str=sc.nextLine();
          HashSet<Character> set=new HashSet<>();
          StringBuilder ans=new StringBuilder();
          for(char i:str.toCharArray()){
             if(!set.contains(i)){
                 ans.append(i);
              }
              set.add(i);
           }
           System.out.println(ans.toString());
       }
}
