public class calProfitAndLoss{
   public static void main(String[]args){
       int SP=191; //Selling Price
       int CP=129; //Cost Price
       int Profit=SP-CP;
       double Profit_Percentage = (Profit / (double) CP) * 100;
       System.out.println("The Cost Price is INR "+ CP+" and Selling Price is INR "+SP);
       System.out.println("The Profit is INR "+Profit+" and the Profit Percentage is "+Profit_Percentage);
   }
}
