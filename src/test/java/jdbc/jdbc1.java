package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc1 {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://127.0.0.1:3306/aug4th2025"; 
        String user = "root";
        String password = "Dhanu@123";

        String insertsql = "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";
        String readsql = "SELECT * FROM students";


        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to DB");

   
        PreparedStatement pstmt = con.prepareStatement(insertsql);
        pstmt.setInt(1, 106);
        pstmt.setString(2, "rahul");
        pstmt.setInt(3, 23);
        int rows = pstmt.executeUpdate();
        System.out.println("Inserted: " + rows);


        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(readsql);
        while (rs.next()) {
            System.out.println("id: " + rs.getInt("id"));
            System.out.println("name: " + rs.getString("name"));
            System.out.println("age: " + rs.getInt("age"));
            System.out.println("--------------------");
        }


        rs.close();
        stmt.close();
        pstmt.close();
        con.close();
    }
}
