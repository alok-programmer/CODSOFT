import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Successfully deposited: " + amount);
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(" Successfully withdrawn: " + amount);
        } else if (amount > balance) {
            System.out.println(" Insufficient balance.");
        } else {
            System.out.println(" Invalid withdrawal amount.");
        }
    }

    public void checkBalance() {
        System.out.println(" Current Balance: " + balance);
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        this.sc = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = sc.nextDouble();
                    account.withdraw(wd);
                    break;
                case 4:
                    System.out.println(" Thank you for using the ATM!");
                    return;
                default:
                    System.out.println(" Invalid choice, please try again.");
            }
        }
    }
}

public class Task3_ATMInterface {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000); 
        ATM atm = new ATM(acc);
        atm.menu();
    }
}
