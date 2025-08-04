package aug;


import java.util.Scanner;

public class lab9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

   
        System.out.print("Enter a string: ");
        String input = sc.next();

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
               
                System.out.println("Result: " + input + input);
                break;

            case 2:
            
                StringBuilder sb1 = new StringBuilder(input);
                for (int i = 0; i < sb1.length(); i++) {
                    if ((i + 1) % 2 != 0) {
                        sb1.setCharAt(i, '#');
                    }
                }
                System.out.println("Result: " + sb1.toString());
                break;

            case 3:
 
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    if (sb2.indexOf(String.valueOf(ch)) == -1) {
                        sb2.append(ch);
                    }
                }
                System.out.println("Result: " + sb2.toString());
                break;

            case 4:
                StringBuilder sb3 = new StringBuilder();
                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    if ((i + 1) % 2 != 0) {
                        sb3.append(Character.toUpperCase(ch));
                    } else {
                        sb3.append(ch);
                    }
                }
                System.out.println("Result: " + sb3.toString());
                break;

            default:
                System.out.println("error");
        }


    }
}

