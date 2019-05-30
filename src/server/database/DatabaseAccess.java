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
    private final String url = "jdbc:postgresql://localhost/dvdrental";
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
            System.out.println("Error");
        }
    }

    public void getTable(String tableName){

        tableName = tableName.toLowerCase();
        try {
            ResultSet rs;

            if (tableName.equals("products")){

                statement = connection.prepareStatement("SELECT * FROM " + tableName);
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

                    productTable.add(new Product(productName,null,productID,categoryID,0,stock,onSale,description,0));
                }
            }

            else if (tableName.equals("orders")){

                statement = connection.prepareStatement("SELECT * FROM " + tableName);
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
        return productTable;
    }

    @Override
    public List<Order> getOrders() throws RemoteException {
        return orderTable;
    }

    @Override
    public List<Categories> getCategory(Categories category) throws RemoteException {
        return null;
    }

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
    public void addProduct(Product product) throws RemoteException, SQLException {

        PreparedStatement statement = connection.prepareStatement
                ("INSERT INTO Products VALUES ("+ product.getProductID()+","
                        +product.getQuantity()+","+product.getPrice()+","
                        +product.getName()+","+product.getCategoryID()+","
                        +product.getDescription()+","+product.isOnSale()+")");
        statement.executeQuery();
    }

    @Override
    public void addOrder(Order order) throws RemoteException, SQLException {
        PreparedStatement statement = connection.prepareStatement
                ("INSERT INTO Orders VALUES ("+order.getOrderID()+","+ "CURRENT_DATE"
                        +","+order.getShoppingBag().subTotal()+","+order.getCostumerName()
                        +","+order.getAdress()+","+order.getPhone());
        statement.executeQuery();
    }

    @Override
    public void updateProduct(Product product, String columnToUpdate, String newValue) throws RemoteException, SQLException {
        int id = product.getProductID();
        PreparedStatement statement = connection.prepareStatement
                ("UPDATE Products SET " + columnToUpdate + " = " + newValue
                        + " WHERE " + "productID" + "=" + id);
    }


    @Override
    public void purchase(int amount, Product product) throws RemoteException, SQLException {
        int index = productTable.indexOf(getProduct(product));
        productTable.get(index).setPurchasedQuantity(amount);
    }

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

