import java.util.ArrayList;
import java.util.Scanner;

class Account {
    int accountNumber;
    String name;
    double balance;

    Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully!");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    void display() {
        System.out.println("\nAccount Number : " + accountNumber);
        System.out.println("Name           : " + name);
        System.out.println("Balance        : Rs." + balance);
    }
}

public class BankManagementSystem {

    static ArrayList<Account> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Account findAccount(int number) {
        for (Account acc : accounts) {
            if (acc.accountNumber == number) {
                return acc;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Number: ");
                    int number = sc.nextInt();

                    if (findAccount(number) != null) {
                        System.out.println("Account already exists!");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Deposit: Rs.");
                    double balance = sc.nextDouble();

                    if (balance < 0) {
                        System.out.println("Invalid initial deposit.");
                        break;
                    }

                    accounts.add(new Account(number, name, balance));
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    number = sc.nextInt();

                    Account acc = findAccount(number);

                    if (acc != null) {
                        System.out.print("Enter deposit amount: Rs.");
                        double amount = sc.nextDouble();
                        acc.deposit(amount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    number = sc.nextInt();

                    acc = findAccount(number);

                    if (acc != null) {
                        System.out.print("Enter withdrawal amount: Rs.");
                        double amount = sc.nextDouble();
                        acc.withdraw(amount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    number = sc.nextInt();

                    acc = findAccount(number);

                    if (acc != null) {
                        System.out.println("Current Balance: Rs." + acc.balance);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    number = sc.nextInt();

                    acc = findAccount(number);

                    if (acc != null) {
                        acc.display();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using Bank Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
