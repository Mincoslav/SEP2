package server.database;

import domain.Categories;
import domain.Order;
import domain.Product;
import domain.ShoppingBag;
import org.postgresql.Driver;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess implements DatabaseCon {

    Connection connection;
    private PreparedStatement statement ;
    private final String url = "jdbc:postgresql://localhost/dvdrental";
    private final String user = "postgres";
    private final String password = "postgres";


    public DatabaseAccess(){
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }






    public void getTable(String table){
        table = table.toLowerCase();
        try {
            ResultSet rs;

            if (table.equals("products")){
                statement = connection.prepareStatement("SELECT * FROM " + table);
                rs = statement.executeQuery();
                ArrayList<Product> products = new ArrayList<>();
                while (rs.next()) {
                    String name = rs.getString("name");
                    int stock = rs.getInt("stock");
                    int categoryID = rs.getInt("categoryID");
                    products.add(new Product(name,null,0,categoryID,0,stock,false,null,0));
                }

            }

        }
        catch (SQLException e) {
            System.out.println("Error: The table doesn't exist");
        }
        catch (NullPointerException e){
            System.out.println("Error: Null Pointer exception in 'Products' table");
        }



    }



    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection connect() throws RemoteException, SQLException {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    @Override
    public List<Product> getProducts() throws ClassNotFoundException, SQLException {
        List<Product> productList = new ArrayList<Product>();

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres?currentSchema=sales_system",
                "postgres", "password");


        // JDBC driver name and database URL
        String JDBC_DRIVER = "com.postgres.jdbc.Driver";
        String DB_URL = "jdbc:postgresql://localhost:5433/postgres?currentSchema=sales_system";

        DriverManager.registerDriver(new org.postgresql.Driver());

        // Database credentials
        String USER = "postgres";
        String PASS = "password";

        Connection conn = null;
        Statement stmt = null;

        //Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");

        return null;
    }

    @Override
    public ArrayList<Order> getOrders() throws RemoteException {
        return null;
    }

    @Override
    public List<Categories> getCategory(Categories category) throws RemoteException {
        return null;
    }

    @Override
    public Product getProduct(Product product) throws RemoteException {
        return null;
    }

    @Override
    public void removeFromShoppingBag(Product product) throws RemoteException {

    }

    @Override
    public void purchase(String name, String adress, int phone) {

    }

    @Override
    public Order getOrderByID(int orderID) throws RemoteException {
        return null;
    }

    @Override
    public void addProductToShoppingBag(ShoppingBag shoppingBag, Product product) throws RemoteException {

    }


}

