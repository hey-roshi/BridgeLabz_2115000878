public class discountAmtAndPrice{
public static void main(String[] args) {
int fee = 125000; // Course fee
int discountPercent = 10; // Discount percentage
double discount = (fee * discountPercent) / 100.0;
double final_Fee = fee - discount;
System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + final_Fee);
   }
}

