package aug;

import java.time.LocalDate;
import java.util.Scanner;

public class lab13 {
	public static LocalDate calculateExpiryDate(LocalDate purchaseDate, int warrantyYears, int warrantyMonths) {
        return purchaseDate.plusYears(warrantyYears).plusMonths(warrantyMonths);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Purchase date: (yyyy-mm-dd)");
		String date = sc.nextLine();
		
		System.out.print("warranty years: ");
        int years = sc.nextInt();

        System.out.print("warranty months: ");
        int months = sc.nextInt();
        
        LocalDate purDate = LocalDate.parse(date);
        LocalDate expDate = calculateExpiryDate(purDate,years,months);

        System.out.println("warrenty expires:"+ expDate);

	}

}

