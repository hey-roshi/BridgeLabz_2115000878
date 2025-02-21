import java.util.Scanner;
public class nestedTryCatch{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        try{
            System.out.print("Enter the number of elements in the array: ");
            int size=scanner.nextInt();
            int[] arr=new int[size];
            System.out.println("Enter " + size + " elements:");
            for(int i=0;i<size;i++){
                arr[i]=scanner.nextInt();
            }
            System.out.print("Enter the index to access: ");
            int index=scanner.nextInt();
            try{
                int element=arr[index];
                System.out.print("Enter the divisor: ");
                int divisor=scanner.nextInt();
                try{
                    int result=element/divisor;
                    System.out.println("Result: " + result);
                } catch(ArithmeticException e){
                    System.out.println("Cannot divide by zero!");
                }

            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Invalid array index!");
            }
        }catch(Exception e){
            System.out.println("Invalid input. Please enter numeric values.");
        }finally{
            System.out.println("Operation completed.");
        }
    }
}
