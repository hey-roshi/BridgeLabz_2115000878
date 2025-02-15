public class firstLastOcc{
      public static int firstOcc(int arr[],int target){
         int ans=-1;
         int low=0, high=arr.length-1;
         while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
               ans=mid;
               high=mid-1;
             }else if(arr[mid]<target){
               low=mid+1;
             }else{
               high=mid-1;
             }
         }
         return ans;
      }
      public static int lastOcc(int arr[],int target){
         int ans=-1;
         int low=0, high=arr.length-1;
         while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
               ans=mid;
               low=mid+1;
             }else if(arr[mid]<target){
               low=mid+1;
             }else{
               high=mid-1;
             }
         }
         return ans;
      }
      public static void main(String args[]){
          int arr[]={1,1,1,2,3,4,5};
          int ans[]=new int[2];
          int target=1;
          ans[0]=firstOcc(arr,target);
          ans[1]=lastOcc(arr,target);
          System.out.println(ans[0]+" "+ans[1]);
      }
}


