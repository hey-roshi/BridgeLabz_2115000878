public class interestCalculator{
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException{
        if(amount<0||rate<0){
            throw new IllegalArgumentException("Amount and rate must be positive");
        }
        return(amount*rate*years)/100; 
    }
    public static void main(String[] args){
        try{
            double interest=calculateInterest(1000,5,2);
            System.out.println("Calculated Interest: " + interest);
            double invalidInterest = calculateInterest(-500, 4, 3);
            System.out.println("Calculated Interest: " + invalidInterest);

        }catch(IllegalArgumentException e){
            System.out.println("Invalid input: " + e.getMessage()); // Handles the propagated exception
        }
    }
}
