package File_Handling;

import java.util.*;

public class lab4 {
    public static void main(String[] args) {
        ArrayList<String> products = new ArrayList<>(Arrays.asList("bat", "bot", "bottle", "bag"));

        Collections.sort(products);

        System.out.println("Sorted Product Names:");
        for (String product : products) {
            System.out.println(product);
        }
    }
}