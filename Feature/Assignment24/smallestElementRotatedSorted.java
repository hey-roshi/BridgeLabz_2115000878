public class smallestElementRotatedSorted{
    public static int findMin(int[] nums) {
        int low=0, high=nums.length-1;
        int ans=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[low]<=nums[mid]){
                if(nums[low]<ans){
                   ans=nums[low];
                   index=low;
                }
                low=mid+1;
            }else{
                if(nums[mid]<ans){
                   ans=nums[mid];
                   index=mid;
                }
                high=mid-1;
            }
        }
        return index;
    }
    public static void main(String args[]){
        int arr[]={5,6,7,0,1,2};
        int ans=findMin(arr);
        System.out.println(ans);
    }
}

