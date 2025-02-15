public class peakElement{
     public static int peak(int arr[]){
        if(arr.length==1){
           return arr[0];
         }
         if(arr[0]>arr[1]){
           return arr[0];
         }
         if(arr[arr.length-1]>arr[arr.length-2]){
           return arr[arr.length-1];
         }
         int low=1, high=arr.length-2;
         while(low<=high){
           int mid=low+(high-low)/2;
           if(arr[mid]>arr[mid+1] &&arr[mid]>arr[mid-1]){
                return arr[mid];
           }else if (arr[mid]>arr[mid-1]){
                low=mid+1;
           }else{
                 high=mid-1;
           }
         }
         return -1;
      }
      public static void main(String arga[]){
         int arr[]={1,2,3,1};
         int ans=peak(arr);
         System.out.println(ans);
      }
}
