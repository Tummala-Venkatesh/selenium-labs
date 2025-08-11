package File_Handling;

import java.io.*;
import java.util.*;

public class lab2 {
    public static void main(String[] args) {
        File file = new File("numbers.txt");
        System.out.println("Looking for file at: " + file.getAbsolutePath());

        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        try (Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(",");
            System.out.println("Even Numbers:");
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number % 2 == 0) {
                    System.out.print(number + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
