import java.util.*;
public class subArraysZeroSum{
     public static void main(String args[]){
          Scanner sc=new Scanner(System.in);
          int n=sc.nextInt();
          int arr[]=new int[n];
          for(int i=0;i<n;i++){
             arr[i]=sc.nextInt();
          }
          int k=sc.nextInt();
          int ans=subarraySum(arr,k);
          System.out.println(ans);
     }
      public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int sum=0, count=0;
        hm.put(0,1);
        for(int i=0;i<nums.length;i++){
          sum+=nums[i];
          if(hm.containsKey(sum-k)){
            count+=hm.get(sum-k);
          }
          hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
