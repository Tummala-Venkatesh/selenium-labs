package exception_handling;

import java.util.Scanner;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) throws Exception {
        if (salary < 3000) {
            throw new Exception("Salary must be greater than or equal to 3000.");
        }
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: ₹" + salary);
    }
}

public class lab3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter employee name: ");
            String name = scanner.nextLine();

            System.out.print("Enter employee salary: ");
            int salary = (int) scanner.nextDouble();

            Employee emp = new Employee(name, salary);
            emp.display();

        } catch (Exception e) {
            System.out.println("Employee Exception: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
