import java.util.Scanner;
public class inputStudentFees{
    public static void main(String[] args) {
          Scanner sc= new Scanner(System.in);
          double fee, discountPercent, discount, finalFee;
          System.out.print("Enter the total student fee: ");
          fee = sc.nextDouble();
          System.out.print("Enter the university discount percentage: ");
          discountPercent =sc.nextDouble();
          discount = (discountPercent / 100) * fee;
          finalFee = fee - discount;
          System.out.println("The discount amount is "+ discount+ " and the final discounted fee is INR "+finalFee);
    }
}
