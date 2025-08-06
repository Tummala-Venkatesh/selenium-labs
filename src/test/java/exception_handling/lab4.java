package exception_handling;

import java.util.Arrays;
import java.util.Scanner;

public class lab4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

 
        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        String[] products = new String[n];

       
        for (int i = 0; i < n; i++) {
            System.out.print("Enter product name " + (i + 1) + ": ");
            products[i] = scanner.nextLine();
        }

        
        Arrays.sort(products);

       
        System.out.println("\nSorted product names:");
        for (String product : products) {
            System.out.println(product);
        }

        scanner.close();
    }
}

