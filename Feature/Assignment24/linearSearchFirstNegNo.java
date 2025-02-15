import java.util.*;
public class linearSearchFirstNegNo{
     public static int findIndex(int arr[]){
         for(int i=0;i<arr.length;i++){
             if(arr[i]<0){
                return i;
                
             }
         }
         return -1;
     }
     public static void main(String args[]){
          int arr[]={1,3,0,-2,5};
          int ans=findIndex(arr);
          System.out.println(ans);
     }
}
