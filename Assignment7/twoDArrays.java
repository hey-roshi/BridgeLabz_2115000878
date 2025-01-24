import java.util.*;
public class twoDArrays{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of rows: ");
        int row = sc.nextInt();
        System.out.print("Enter the no of columns: ");
        int column = sc.nextInt();

        // Create a 2D array
        int[][] matrix = new int[row][column];
        System.out.println("Enter the elements of the 2D array:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Element at [" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        // Create a 1D array to store elements of the 2D array
        int[] array = new int[row * column];
        int index = 0;
        // Copy elements from the 2D array to the 1D array
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                array[index] = matrix[i][j];
                index++;
            }
        }
        System.out.println("The 2D Array:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("The 1D Array:");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
