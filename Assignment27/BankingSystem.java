import java.util.*;

class BankingSystem {
    private HashMap<Integer, Double> accountBalances = new HashMap<>();
    private TreeMap<Double, Integer> sortedAccounts = new TreeMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Add a new account
    public void addAccount(int accountNumber, double balance) {
        accountBalances.put(accountNumber, balance);
        sortedAccounts.put(balance, accountNumber);
    }

    // Deposit money into an account
    public void deposit(int accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            double newBalance = accountBalances.get(accountNumber) + amount;
            sortedAccounts.remove(accountBalances.get(accountNumber)); // Remove old balance
            accountBalances.put(accountNumber, newBalance);
            sortedAccounts.put(newBalance, accountNumber); // Add new balance
        } else {
            System.out.println("Account not found!");
        }
    }

    // Add withdrawal request to the queue
    public void requestWithdrawal(int accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber)) {
            withdrawalQueue.offer(new WithdrawalRequest(accountNumber, amount));
        } else {
            System.out.println("Invalid account number!");
        }
    }

    // Process withdrawal requests
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            int accNum = request.accountNumber;
            double amount = request.amount;

            if (accountBalances.containsKey(accNum) && accountBalances.get(accNum) >= amount) {
                sortedAccounts.remove(accountBalances.get(accNum)); // Remove old balance
                accountBalances.put(accNum, accountBalances.get(accNum) - amount);
                sortedAccounts.put(accountBalances.get(accNum), accNum); // Update balance
                System.out.println("Withdrawal of $" + amount + " from Account " + accNum + " successful.");
            } else {
                System.out.println("Insufficient balance or invalid account!");
            }
        }
    }

    // Display all accounts sorted by balance
    public void displaySortedAccounts() {
        System.out.println("Accounts sorted by balance: " + sortedAccounts);
    }

    // Nested class for withdrawal request
    private static class WithdrawalRequest {
        int accountNumber;
        double amount;

        WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Adding accounts
        bank.addAccount(101, 5000);
        bank.addAccount(102, 3000);
        bank.addAccount(103, 7000);

        // Depositing money
        bank.deposit(101, 2000);
        bank.deposit(102, 1000);

        // Request withdrawals
        bank.requestWithdrawal(101, 1000);
        bank.requestWithdrawal(103, 500);
        bank.requestWithdrawal(102, 5000); // Should fail (insufficient balance)

        // Process withdrawals
        bank.processWithdrawals();

        // Display sorted accounts
        bank.displaySortedAccounts();
    }
}
