import java.util.*  ;
public class Bank {

    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        }
    }

    public void printAllAccounts() {
        for (BankAccount account : accounts) {
            System.out.println(account);
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();

        // Add some accounts to the bank
        bank.addAccount(new BankAccount("1234567890", "Alice"));
        bank.addAccount(new BankAccount("9876543210", "Bob"));

        // Deposit some money into Alice's account
        bank.deposit("1234567890", 1000.00);

        // Withdraw some money from Bob's account
        bank.withdraw("9876543210", 500.00);

        // Print all accounts
        bank.printAllAccounts();
    }
}

class BankAccount {

    private String accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(String accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
