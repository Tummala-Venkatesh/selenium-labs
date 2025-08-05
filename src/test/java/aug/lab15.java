package aug;

import java.time.LocalDate;
import java.time.Period;

public class lab15 {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

   
    public lab15() {
        this.firstName = "";
        this.lastName = "";
        this.dateOfBirth = LocalDate.now();
    }

  
    public lab15(String firstName, String lastName, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dob;
    }

    
    public int calculateAge() {
        LocalDate today = LocalDate.now();
        Period period = Period.between(this.dateOfBirth, today);
        return period.getYears();
    }

    
    public String getFullName() {
        return firstName + " " + lastName;
    }

    
    public void displayPersonDetails() {
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Age: " + calculateAge() + " years");
    }

  
    public static void main(String[] args) {
        lab15 p = new lab15("Venkatesh", "Tummala", LocalDate.of(2000, 6, 15));
        p.displayPersonDetails();
    }
}

