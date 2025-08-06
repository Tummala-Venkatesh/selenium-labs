package exception_handling;

import java.util.Scanner;


/*class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}*/

// Class to validate age
class Person {
    private int age;

    public Person(int age) throws Exception {
        if (age <= 15) {
            throw new Exception("Age must be greater than 15.");
        }
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Valid age: " + age);
    }
}

// Main class
public class lab2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            Person person = new Person(age);
            person.displayAge();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

