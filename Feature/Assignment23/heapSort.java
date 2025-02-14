import java.util.Arrays;
class heapSort{
    static void heapify(int arr[],int n,int i){
        int largest=i; 
        // left index=2*i+1
        int l=2*i+1; 
        // right index=2*i+2
        int r=2*i+2;
        // If left child is larger than root
        if(l<n&&arr[l]>arr[largest]){
            largest=l;
        }
        // If right child is larger than largest so far
        if(r<n&&arr[r]>arr[largest]){
            largest=r;
        }
        // If largest is not root
        if(largest!=i){
            int temp=arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;
            // Recursively heapify the affected sub-tree
            heapify(arr,n,largest);
        }
    }
    static void heapSort(int arr[]){
        int n = arr.length;
        for(int i=n/2-1;i>=0;i--){
            heapify(arr,n,i);
        }
        for(int i=n-1;i>0;i--){
            int temp=arr[0]; 
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,i,0);
        }
    }
    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = {9, 4, 3, 8, 10, 2, 5}; 
        heapSort(arr);
        System.out.println("Sorted array is ");
        printArray(arr);
    }
}
