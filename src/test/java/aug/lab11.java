package aug;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class lab11 {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("dd-MM-yyyy:");
        String inputDate = scanner.nextLine();

    
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate userDate = LocalDate.parse(inputDate, formatter);

       
        LocalDate currentDate = LocalDate.now();

        
        Period duration = Period.between(userDate, currentDate);

        System.out.println(duration.getYears()+"years "+duration.getMonths()+" months "+duration.getDays()+"days");

    }
}

