class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        super(message);
    }
}
class BankAccount{
    private double balance;
    public BankAccount(double balance){
        this.balance=balance;
    }
    public void withdraw(double amount) throws InsufficientBalanceException,IllegalArgumentException{
        if(amount<0){
            throw new IllegalArgumentException("Invalid amount!"); 
        }
        if(amount>balance){
            throw new InsufficientBalanceException("Insufficient balance!"); 
        }
        balance-=amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
}
public class bankTransactionSystem{
    public static void main(String[] args){
        BankAccount account=new BankAccount(500.0); 
        try{
            account.withdraw(200);  
            account.withdraw(400); 
            account.withdraw(-50);  
        }catch (InsufficientBalanceException e){
            System.out.println(e.getMessage());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
