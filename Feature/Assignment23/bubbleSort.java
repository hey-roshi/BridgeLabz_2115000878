public class bubbleSort{
    public static void printArray(int arr[], int size){
        for(int i=0;i<size;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String args[]){
        int arr[]={ 64, 34, 25, 12, 22, 11, 90 };
        int n=arr.length;
        bubbleSorting(arr, n);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
    public static void bubbleSorting(int arr[],int n){
         for(int i=0;i<n-1;i++){
             boolean swapped=false;
             for(int j=0;j<n-i-1;j++){
                if(arr[j+1]<arr[j]){ 
                  swapped=true;
                  int temp=arr[j];
                  arr[j]=arr[j+1];
                  arr[j+1]=temp;
                }
              }
              if(swapped==false){
                   break;
              }
          }
     }
}
