package inhertence;

/* import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private String gender;
    private LocalDate dob;

    public Person(String name, String gender, LocalDate dob) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", DOB: " + dob;
    }
}

class Account {
    private String accNumber;
    private String accHolderName;
    private double balance;

    public Account(String accNumber, String accHolderName, double balance) {
        this.accNumber = accNumber;
        this.accHolderName = accHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount)
            balance -= amount;
        else
            System.out.println("Insufficient balance.");
    }

    public double getBalance() {
        return balance;
    }

    public String toString() {
        return "Account Number: " + accNumber + ", Holder: " + accHolderName + ", Balance: " + balance;
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accNumber, String accHolderName, double balance, double interestRate) {
        super(accNumber, accHolderName, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }

    public String toString() {
        return super.toString() + ", Interest Rate: " + interestRate + "%";
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accNumber, String accHolderName, double balance, double overdraftLimit) {
        super(accNumber, accHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public void withdraw(double amount) {
        if (getBalance() + overdraftLimit >= amount)
            deposit(-amount); 
        else
            System.out.println("Overdraft limit exceeded.");
    }

    public String toString() {
        return super.toString() + ", Overdraft Limit: " + overdraftLimit;
    }
}

public class lab2 {
    public static void main(String[] args) {
     
        Person person = new Person("Tummala Venkatesh", "Male", LocalDate.of(2002, 8, 15));
        System.out.println("=== Person Info ===");
        System.out.println(person);

      
        SavingsAccount savings = new SavingsAccount("S123", "Tummala Venkatesh", 5000.0, 5.0);
        System.out.println("\n=== Savings Account ===");
        savings.deposit(1000);
        savings.addInterest();
        System.out.println(savings);

        CurrentAccount current = new CurrentAccount("C456", "Tummala Venkatesh", 2000.0, 1000.0);
        System.out.println("\n=== Current Account ===");
        current.withdraw(2500); // within overdraft
        current.withdraw(1000); // exceeds overdraft
        System.out.println(current);
    }
}
*/