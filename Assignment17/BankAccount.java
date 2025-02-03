import java.util.*;
public class BankAccount{
     static String bankName="Indian";
     static int totalAcc=0;
     private String accHolderName;
     final int accountNo;
     private double balance;
     public BankAccount(String accHolderName, int accountNo, double balance){
         this.accHolderName=accHolderName;
         this.accountNo=accountNo;
         this.balance=balance;
         totalAcc++;
     }
     public static int getTotalAccount(){
          return totalAcc;
     }
     public void displayDetails(){
          System.out.println("Bank name :"+bankName);
          System.out.println("Account Holder: "+accHolderName);
          System.out.println("Account Number: "+accountNo);
          System.out.println("Balance: "+balance);   
     }
     public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        int number = sc.nextInt();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        BankAccount account = new BankAccount(name, number, balance);
        System.out.println("\nAccount Details:");
        if(account instanceof BankAccount){
           account.displayDetails();
        }else{
           System.out.println("not indstance");
        }
        System.out.println("Total Accounts: " + BankAccount.getTotalAccount());
    }
}    
     
