package aug;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class lab14 {

    public static void printDateTimeForZone(String zoneId) {
        try {
            ZoneId zone = ZoneId.of(zoneId);
            ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);

            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
            System.out.println("Current date and time in " + zoneId + ": " + zonedDateTime.format(f));
        } catch (Exception e) {
            System.out.println("Invalid Zone ID");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Zone ID");
        String zoneId = scanner.nextLine();

        printDateTimeForZone(zoneId);
        scanner.close();
    }
}
