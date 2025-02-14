public class selectionSort{
    public static void selectionSort(int[] arr){
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int minIndex=i; //Assume the first element is the minimum
            // Find the minimum element in the remaining unsorted part
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }
            // Swap the found minimum element with the first element of the unsorted part
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
    }
    public static void printArray(int[] arr){
        for(int num:arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int arr[]={64, 25, 12, 22, 11};
        System.out.println("Original array:");
        printArray(arr);
        selectionSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
