package exception_handling;

import java.util.Scanner;


class NameNotValidException extends Exception {
    public NameNotValidException(String message) {
        super(message);
    }
}

class Employee {
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) throws NameNotValidException {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new NameNotValidException("First name cannot be blank.");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new NameNotValidException("Last name cannot be blank.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void display() {
        System.out.println("Full Name: " + firstName + " " + lastName);
    }
}
public class lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter First Name: ");
            String firstName = sc.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = sc.nextLine();

            Employee emp = new Employee(firstName, lastName);
            emp.display();

        } catch (NameNotValidException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

