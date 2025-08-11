package File_Handling;

import java.io.*;

public class lab1 {
    public static void main(String[] args) {
        String filePath = "file.txt";
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("File not found at: " + file.getAbsolutePath());
            return;
        }

        try (FileReader fr = new FileReader(file);
             FileWriter fw = new FileWriter(file)) {

            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = fr.read()) != -1) {
                sb.append((char) ch);
            }

            String revContent = sb.reverse().toString();
            fw.write(revContent);

            System.out.println("File content reversed");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
