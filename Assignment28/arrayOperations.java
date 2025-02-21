import java.util.*;
public class arrayOperations{
     public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        try{
           System.out.println("enter array size");
           int size=sc.nextInt();
           if(size<=0){
              throw new NullPointerException("array not initialised");
           }
           int arr[]=new int[size];
           System.out.println("enter the numbers");
           for(int i=0;i<size;i++){
              arr[i]=sc.nextInt();
           }
           System.out.println("enter the index");
           int index=sc.nextInt();
           System.out.println(arr[index]);
        }catch(ArrayIndexOutOfBoundsException e){
           System.out.println("array index out of bound");
        }catch(NullPointerException e){
           System.out.println("null pointer");
        }catch(Exception e){
           System.out.println("invalid input");
        }
    }
}
