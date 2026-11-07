import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/employees";
        String user = "root";
        String password = "your_password"; // Replace with your actual password

        String sql = "INSERT INTO emp_details (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

        int[] codes = {101, 102, 103, 104, 105};
        String[] names = {"Jenny", "Jacky", "Joe", "John", "Shameer"};
        int[] ages = {25, 30, 20, 40, 25};
        int[] salaries = {10000, 20000, 40000, 80000, 90000};

        try (Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement(sql)){
            System.out.println("Connected to database");

            for (int i = 0; i < codes.length; i++) {
                ps.setInt(1, codes[i]);
                ps.setString(2, names[i]);
                ps.setInt(3, ages[i]);
                ps.setInt(4, salaries[i]);
                ps.executeUpdate();
            }

            System.out.println("5 records inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}