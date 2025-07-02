
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account{
	private String accountHolder;
    private int accountNumber;
    private double balance = 0.0;
    private List<String> transactionHistory;
    
    public Account(String accountHolder, int accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }
    
	public String getAccountHolder() {
		return accountHolder;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public double showBalance() {
		return balance;
	}
	
	public void deposit(double balance) {
		this.balance += Math.abs(balance);
		transactionHistory.add("Deposited: ₹" + balance);
	}
	
	public void withdraw(double balance) {
		if(this.balance < Math.abs(balance)) 
		{
			System.out.println("Insufficient balance.");
            return;
		}
		this.balance -= Math.abs(balance);
		transactionHistory.add("Withdraw: ₹" + balance);
		System.out.println("₹" + Math.abs(balance) + " withdrawn successfully.");
	}
	
	public void printTransactionHistory() {
		for(String t : transactionHistory) {
			System.out.println(t);
		}
	}   
}

class BankApp{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Account Aman = new Account("Aman Yadav", 1001);

        int choice;
        do {
            System.out.println("\n===== Bank Menu =====");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ₹");
                    int depositAmt = scanner.nextInt();
                    Aman.deposit((double)depositAmt);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    int withdrawAmt = scanner.nextInt();
                    Aman.withdraw((double)withdrawAmt);
                    break;
                case 3:
                    System.out.println(Aman.showBalance());
                    break;
                case 4:
                	Aman.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using our bank.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
