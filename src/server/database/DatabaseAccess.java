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
    private PreparedStatement statement;
    private final String url = "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "postgres";
    private List<Product> productTable;
    private List<Order> orderTable;



    public DatabaseAccess(){
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Requirement for every other method to have data to work with
      Creates List based on the input.
      The legal input is "Products" or "Orders".
    */
    @Override
    public void getTable(String tableName){

        tableName = tableName.toLowerCase();
        try {
            ResultSet rs;

            if (tableName.equals("products")){

                statement = connection.prepareStatement("SELECT * FROM " + tableName+ ";");
                rs = statement.executeQuery();
                productTable = new ArrayList<>();

                while (rs.next()) {

                    int productID = rs.getInt("productID");
                    int stock = rs.getInt("stock");
                    float price = rs.getFloat("price");
                    String productName = rs.getString("name");
                    int categoryID = rs.getInt("categoryID");
                    String description = rs.getString("description");
                    boolean onSale = rs.getBoolean("onSale");

                    productTable.add(new Product(productName,"",productID,categoryID,0,stock,onSale,description,0));
                }
            }

            else if (tableName.equals("orders")){

                statement = connection.prepareStatement("SELECT * FROM " + tableName +";");
                rs = statement.executeQuery();
                orderTable = new ArrayList<>();

                while (rs.next()) {

                    int orderID = rs.getInt("orderID");
                    Date date = rs.getDate("date");
                    float price = rs.getFloat("price");
                    String name = rs.getString("name");
                    String address = rs.getString("address");
                    int phone = rs.getInt("phone");

                    ShoppingBag shoppingBag = new ShoppingBag();
                    orderTable.add(new Order(shoppingBag,name,address,phone));
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
    /* Method for closing the connection.
       Recommended to use after getting the tables or updating them.
     */
    @Override
    public void close() {
        try {
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Force connect method in case of error during object initialization
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
    //Returns the 'Products' table from database in form of List
    @Override
    public List<Product> getProducts() throws ClassNotFoundException, SQLException {
        return productTable;
    }
    //Returns the 'Orders' table from database in form of List
    @Override
    public List<Order> getOrders() throws RemoteException {
        return orderTable;
    }
    //Return individual product from 'productTable' List.
    @Override
    public Product getProduct(Product product) throws RemoteException {
        int temp_index = 0;

        for (int i = 0; i < productTable.size() ; i++) {
            if (productTable.get(i).equals(product)) {
                temp_index = productTable.indexOf(product);
            }
        }
        return productTable.get(temp_index);
    }

    @Override
    public Product getProduct(int index) throws RemoteException, SQLException {
        return productTable.get(index);
    }

    //Adds individual product to the database table of "Products".
    @Override
    public void addProduct(Product product) throws RemoteException, SQLException {

        PreparedStatement statement = connection.prepareStatement
                ("INSERT INTO Products VALUES ("+ product.getProductID()+","
                        +product.getQuantity()+","+product.getPrice()+","
                        +product.getName()+","+product.getCategoryID()+","
                        +product.getDescription()+","+product.isOnSale()+");");
        statement.executeQuery();
    }
    //Adds individual product to the database table of "Orders".
    @Override
    public void addOrder(Order order) throws RemoteException, SQLException {
        PreparedStatement statement = connection.prepareStatement
                ("INSERT INTO Orders VALUES ("+order.getOrderID()+","+ "CURRENT_DATE"
                        +","+order.getShoppingBag().subTotal()+","+order.getCostumerName()
                        +","+order.getAdress()+","+order.getPhone()+";");
        statement.executeQuery();
    }
    //Updates individual product in the database based on the column name that is inputted.
    @Override
    public void updateProduct(Product product, String columnToUpdate, String newValue) throws RemoteException, SQLException {
        int id = product.getProductID();
        PreparedStatement statement = connection.prepareStatement
                ("UPDATE Products SET " + columnToUpdate + " = " + newValue
                        + " WHERE " + "productID" + "=" + id + ";");
        statement.executeQuery();
    }

    //Decreases the 'stock' field for product based on its 'productID' value.
    //Possible connect()/close() missing
    @Override
    public void purchase(int amount, Product product) throws RemoteException, SQLException {
        int index = productTable.indexOf(getProduct(product));
        int amountInStock = product.getQuantity() - amount;
        productTable.get(index).setPurchasedQuantity(amountInStock);
        product = productTable.get(index);
        int quantity = product.getQuantity();
        int productID = product.getProductID();
        PreparedStatement statement = connection.prepareStatement
                ("UPDATE Products SET stock = " + quantity
                        + " WHERE productID = " + productID+";");
    }
    //Returns an order based on the 'orderID' variable.
    @Override
    public Order getOrderByID(int orderID) throws RemoteException {
        ShoppingBag emptyShoppingBag = new ShoppingBag();
        Order order = new Order(emptyShoppingBag,"","",0);

        for (int i = 0; i < orderTable.size() ; i++) {
            if (orderID == orderTable.get(i).getOrderID()) {
                order = orderTable.get(i);
            }
            else {
                System.out.println("This order doesn't exist.");
            }
        }
        return order;
    }

}

