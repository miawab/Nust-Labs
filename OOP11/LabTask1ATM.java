import java.util.Scanner;

public class LabTask1ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 5000;
        boolean running = true;

        while (running) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Calculate Service Split (balance / value)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            try {
                int choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter withdraw amount: ");
                    double amount = sc.nextDouble();
                    if (amount < 0) {
                        throw new IllegalArgumentException("Amount cannot be negative");
                    }
                    if (amount > balance) {
                        throw new ArithmeticException("Insufficient balance");
                    }
                    balance = balance - amount;
                    System.out.println("Withdraw successful");
                    System.out.println("Remaining balance: " + balance);
                } else if (choice == 2) {
                    System.out.print("Enter deposit amount: ");
                    double amount = sc.nextDouble();
                    if (amount < 0) {
                        throw new IllegalArgumentException("Amount cannot be negative");
                    }
                    balance = balance + amount;
                    System.out.println("Deposit successful");
                    System.out.println("New balance: " + balance);
                } else if (choice == 3) {
                    System.out.println("Current balance: " + balance);
                } else if (choice == 4) {
                    System.out.print("Enter value to divide balance by: ");
                    double value = sc.nextDouble();
                    if (value == 0) {
                        throw new ArithmeticException("Division by zero is not allowed");
                    }
                    double result = balance / value;
                    System.out.println("Result: " + result);
                } else if (choice == 5) {
                    running = false;
                    System.out.println("Thank you for using ATM");
                } else {
                    System.out.println("Invalid menu choice");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input type. Please enter numbers only.");
                sc.nextLine();
            }
        }

        sc.close();
    }
}
