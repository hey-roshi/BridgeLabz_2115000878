import java.util.*;
public class twoSum{
    public static void main(String args[]){
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          int arr[]=new int[n];
          for(int i=0;i<n;i++){
             arr[i]=sc.nextInt();
          }
         int target=sc.nextInt();
         int ans[]=new int[2];
         HashMap<Integer,Integer> hm=new HashMap<>();
         for(int i=0;i<arr.length;i++){
             int required=target-arr[i];
             if(hm.containsKey(required)){
                ans[0]=i;
                ans[1]=hm.get(required);
             }
             hm.put(arr[i],i);
         }
         System.out.println(ans[0]);
         System.out.println(ans[1]);

     }
     
}
