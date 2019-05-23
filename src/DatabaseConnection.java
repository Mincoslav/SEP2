import domain.Product;
import org.postgresql.Driver;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseConnection {

    private Connection connection;
    private PreparedStatement statement ;

    public DatabaseConnection(String url,String user,String password){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getTable(String table){

        try {
            statement = connection.prepareStatement("SELECT * FROM Products");
            ResultSet rs = statement.executeQuery();
            ArrayList<Product> persons = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                int stock = rs.getInt("stock");
                int categoryID = rs.getInt("categoryID");
                persons.add(new Product(name,null,categoryID,0,stock,false,null,0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
