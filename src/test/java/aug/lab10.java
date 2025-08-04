package aug;

public class lab10 {

    public static boolean isPositiveString(String str) {
        str = str.toUpperCase();

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) > str.charAt(i + 1)) {
                return false; 
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "APPLE"; 
        boolean result = isPositiveString(input);

        if (result) {
            System.out.println(input + " is a positive string.");
        } else {
            System.out.println(input + " is NOT a positive string.");
        }
    }
}

