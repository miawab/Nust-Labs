public class Task1 {
    public static void main(String[] args) {
        BankAccount[] a = new BankAccount[4];
        a[0] = new SavingsAccount("SA1", "Ali", 50000, 0.08);
        a[1] = new SavingsAccount("SA2", "Sara", 75000, 0.06);
        a[2] = new CurrentAccount("CA1", "Hassan", 30000, 20000);
        a[3] = new CurrentAccount("CA2", "Ayesha", 90000, 15000);

        int i;
        for (i = 0; i < a.length; i++) {
            a[i].deposit(5000);
            a[i].withdraw(7000);
            a[i].calculateInterest();
        }

        BankAccount best = a[0];
        double total = 0;
        for (i = 0; i < a.length; i++) {
            total += a[i].balance;
            if (a[i].balance > best.balance) best = a[i];
        }

        for (i = 0; i < a.length; i++) System.out.println(a[i]);
        System.out.println("Highest: " + best.holderName + " " + best.balance);
        System.out.println("Total bank balance: " + total);
    }
}

class BankAccount {
    String accountNumber;
    String holderName;
    double balance;

    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }

    void calculateInterest() {
    }

    public String toString() {
        return accountNumber + " " + holderName + " " + balance;
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    void calculateInterest() {
        balance = balance + balance * interestRate;
    }
}

class CurrentAccount extends BankAccount {
    double overdraft;

    CurrentAccount(String accountNumber, String holderName, double balance, double overdraft) {
        super(accountNumber, holderName, balance);
        this.overdraft = overdraft;
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance + overdraft) balance -= amount;
    }
}