

import domain.Product;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sep", "postgres", "password");
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Products");
            ResultSet rs = statement.executeQuery();
            ArrayList<Product> persons = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                int stock = rs.getInt("stock");
                int categoryID = rs.getInt("categoryID");
                persons.add(new Product(name,null,categoryID,stock,false,null,0));
            }
            System.out.println(persons);
            /*int salary = 150000;
            String name = "Baker";
            statement = connection.prepareStatement("UPDATE Salesperson SET salary = ? WHERE Name = ?");
            statement.setInt(1, salary);
            statement.setString(2, name);
            statement.executeUpdate();*/
        } finally {
            connection.close();
        }
    }
}
