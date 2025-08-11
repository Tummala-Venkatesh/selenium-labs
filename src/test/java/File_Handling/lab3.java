package File_Handling;

import java.io.*;
import java.util.*;

class Employee implements Serializable 
{
    private long id;
    private String name;
    private int salary;
    private String designation;

    public Employee(long id, String name, int salary, String designation)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
    }

    @Override
    public String toString() 
    {
        return "ID: " + id + " Name: " + name + " Salary: " + salary + " Designation: " + designation;
    }
}

public class lab3
{
    public static void main(String[] args) 
    {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "venkatesh", 30000, "Developer"),
            new Employee(2, "tummala", 40000, "Tester")
        );

        String filename = "employees.dat";

      
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Employee emp : employees)
            {
                out.writeObject(emp);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

       
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) 
        {
            System.out.println("\nEmployee Data from File:");
            while (true) 
            {
                try 
                {
                    Employee emp = (Employee) in.readObject();
                    System.out.println(emp);
                } 
                catch (EOFException e) 
                {
                    break;
                }
            }
        }
        catch (IOException | ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
    }
}