import java.util.*;
public class PairWithGivenSum{
     public static void main(String args[]){
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          int arr[]=new int[n];
          for(int i=0;i<n;i++){
             arr[i]=sc.nextInt();
          }
          int k=sc.nextInt();
          boolean ans=sum(arr,k);
          System.out.println(ans);
     }

     public static boolean sum(int arr[],int target){
          HashMap<Integer,Integer>hm=new HashMap<>();
          int sum=0;
          for(int i=0;i<arr.length;i++){
               if(hm.containsKey(target-arr[i])){
                    return true;
               }
               hm.put(arr[i],i);
          }
          return false;
     }
}
