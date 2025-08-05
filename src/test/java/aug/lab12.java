package aug;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class lab12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String d1 = sc.nextLine();
        LocalDate date1 = LocalDate.parse(d1, formatter);


        String d2 = sc.nextLine();
        LocalDate date2 = LocalDate.parse(d2, formatter);

        if (date1.isAfter(date2)) {
            LocalDate temp = date1;
            date1 = date2;
            date2 = temp;
        }

 
        Period duration = Period.between(date1, date2);

        System.out.println("\nDuration between the two dates:");
        System.out.println(duration.getYears()+"years "+duration.getMonths()+" months "+duration.getDays()+"days");
    }
}

