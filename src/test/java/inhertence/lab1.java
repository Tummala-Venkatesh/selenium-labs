package inhertence;

class Person {
    private String name;
    private float age;


    public Person(String name, float age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAge() {
        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }
}

class Account {
    private static long accCounter = 1001;
    private long accNum;
    private double balance;
    private Person accHolder;

    
    public Account(Person accHolder, double balance) {
        if (balance < 500) {
            throw new IllegalArgumentException("Minimum balance of INR 500 required.");
        }
        this.accNum = accCounter++;
        this.accHolder = accHolder;
        this.balance = balance;
    }

   
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

 
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= 500) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds or minimum balance would be violated.");
        }
    }

   
    public double getBalance() {
        return balance;
    }

 
    public long getAccNum() {
        return accNum;
    }

    public Person getAccHolder() {
        return accHolder;
    }

    public void setAccHolder(Person accHolder) {
        this.accHolder = accHolder;
    }

    public void setBalance(double balance) {
        if (balance >= 500) {
            this.balance = balance;
        }
    }

 
    @Override
    public String toString() {
        return "Account Number: " + accNum +
               "\nAccount Holder: " + accHolder.getName() +
               "\nAge: " + accHolder.getAge() +
               "\nBalance: INR " + balance;
    }
}

public class lab1 {
    public static void main(String[] args) {
     
        Person smith = new Person("Smith", 30.5f);
        Person kathy = new Person("Kathy", 27.8f);

    
        Account smithAcc = new Account(smith, 2000);
        Account kathyAcc = new Account(kathy, 3000);

      
        smithAcc.deposit(2000);         
        kathyAcc.withdraw(2000);        


        System.out.println("\n--- Smith's Account ---");
        System.out.println(smithAcc);

        System.out.println("\n--- Kathy's Account ---");
        System.out.println(kathyAcc);
    }
}
