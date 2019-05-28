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

public class DatabaseConnection implements DatabaseCon {


    private PreparedStatement statement ;

    public DatabaseConnection(String url,String user,String password){
        try {
            Database database = new Database();
            database.connect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final String url = "jdbc:postgresql://localhost/dvdrental";
    private final String user = "postgres";
    private final String password = "postgres";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */




    public void getTable(String table){

        try {
            statement = connection.prepareStatement("SELECT * FROM Products");
            ResultSet rs = statement.executeQuery();
            ArrayList<Product> persons = new ArrayList<>();
            while (rs.next()) {
                String name = rs.getString("name");
                int stock = rs.getInt("stock");
                int categoryID = rs.getInt("categoryID");
                persons.add(new Product(name,null,0,categoryID,0,stock,false,null,0));
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

    @Override
    public List<Product> getProducts() throws RemoteException, ClassNotFoundException, SQLException {
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

    @Override
    public List<Categories> getCategory() throws RemoteException {
        return null;
    }
}
