package server.database;

import domain.Categories;
import domain.Order;
import domain.Product;
import domain.ShoppingBag;

import java.rmi.RemoteException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
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
            //connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for closing the connection.
     * Recommended to use after getting the tables or updating them.
     */
    @Override
    public void close() {
        try {
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return 'List<Order>'
     * @throws RemoteException
     * @throws SQLException
     */
    @Override
    public List<Order> getOrdersTable() throws RemoteException, SQLException {
        connect();
        ResultSet rs;
        statement = connection.prepareStatement("SELECT * FROM orders;");
        rs = statement.executeQuery();
        orderTable = new ArrayList<>();

        while (rs.next()) {

            int orderID = rs.getInt("orderID");
            Date date = rs.getDate("date");
            float price = rs.getFloat("price");
            String name = rs.getString("name");
            String address = rs.getString("address");
            int phone = rs.getInt("phone");
            close();

            ShoppingBag shoppingBag = new ShoppingBag();
            Order order = new Order(shoppingBag,name,address,phone);
            order.setOrderID(orderID);
            orderTable.add(order);
    }
        return orderTable;
    }

    /**
     * @return 'List<Product>'
     * @throws RemoteException
     * @throws SQLException
     */
    @Override
    public List<Product> getProductTable() throws RemoteException, SQLException {
        connect();
        ResultSet rs;
        statement = connection.prepareStatement("SELECT * FROM products;");
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
            String imageUrl = rs.getString("url");
            close();

            productTable.add(new Product(productName, imageUrl, productID, categoryID, stock, price, onSale, description, 0));
        }
        return productTable;
    }

    /**
     *     Force connect method in case of error during object initialization
     * @return
     * @throws RemoteException
     * @throws SQLException
     */
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

    /**
     * @param product
     * @return Return individual product from 'productTable' List.
     * @throws RemoteException
     */
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

    /**
     * @param index
     * @return Returns product based on its index in the 'productTable' List.
     * @throws RemoteException
     * @throws SQLException
     */
    @Override
    public Product getProduct(int index) throws RemoteException, SQLException {
        return productTable.get(index);
    }

    /**
     * Adds individual product to the database table of "Products".
     * @param product
     * @throws RemoteException
     * @throws SQLException
     */
    @Override
    public void addProduct(Product product) throws RemoteException, SQLException {
        getProductTable();
        int index = productTable.indexOf(product);
        for(int i = 0;i <productTable.size();i++ ){
            if(productTable.get(i).getProductID()== product.getProductID()){
                index = i;
            }
        }
        connect();
        if(!(index == -1) ){
            updateProduct(product);
        }else {
            PreparedStatement statement = connection.prepareStatement
                    ("INSERT INTO Products VALUES (?,?,?,?,?,?,?,?);");
            statement.setInt(1, product.getProductID());
            statement.setInt(2, product.getQuantity());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getName());
            statement.setInt(5, product.getCategoryID());
            statement.setString(6, product.getDescription());
            statement.setBoolean(7, product.isOnSale());
            statement.setString(8, product.getImageLocation());
            statement.executeUpdate();
        }


        close();
    }

    /**
     * Adds individual product to the database table of "Orders".
     * @param order
     * @throws RemoteException
     * @throws SQLException
     */
    @Override
    public void addOrder(Order order) throws RemoteException, SQLException {
        connect();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Orders VALUES (?,CURRENT_DATE,?,?,?,?);");
        statement.setInt(1, order.getOrderID());
        statement.setInt(2, order.getShoppingBag().subTotal());
        statement.setString(3, order.getCostumerName());
        statement.setString(4, order.getAdress());
        statement.setInt(5,order.getPhone());

        statement.executeUpdate();
        close();
    }

    /**
     * Updates individual product in the database based on the column name that is inputted.
     * @param product
     * @throws RemoteException
     * @throws SQLException
     */
    @Override
    public void updateProduct(Product product) throws RemoteException, SQLException {
        connect();
        int id = product.getProductID();
        PreparedStatement statement = connection.prepareStatement("UPDATE Products SET  stock = ? , price  = ?,name = ?,categoryid =?,description =?,onsale=?,url =? WHERE productID = ?");
        statement.setInt(1, product.getQuantity());
        statement.setFloat(2, (float) product.getPrice());
        statement.setString(3,product.getName());
        statement.setInt(4,product.getCategoryID());
        statement.setString(5,product.getDescription());
        statement.setBoolean(6,product.isOnSale());
        statement.setString(7,product.getImageLocation());
        statement.setInt(8,product.getProductID());


        statement.executeUpdate();
        close();
    }

    @Override
    public void removeProduct(Product product) throws RemoteException, SQLException {
        connect();
        int id = product.getProductID();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE productid = ?;");
        statement.setInt(1, id);
        statement.executeUpdate();
        close();
    }

    /**
     * Decreases the 'stock' field for product based on its 'productID' value.
     * @param amount
     * @param product
     * @throws RemoteException
     * @throws SQLException
     */
    @Override
    public void purchase(int amount, Product product) throws RemoteException, SQLException {
        connect();
        int index = productTable.indexOf(getProduct(product));
        int amountInStock = product.getQuantity() - product.getPurchasedQuantity();
        productTable.get(index).setPurchasedQuantity(amountInStock);
        product = productTable.get(index);
        int quantity = product.getQuantity();
        int productID = product.getProductID();
        PreparedStatement statement = connection.prepareStatement
                ("UPDATE Products SET stock = ? WHERE productID = ?;");
        statement.setInt(1, amountInStock);
        statement.setInt(2, productID);
        statement.executeUpdate();

        close();
    }

    /**
     * @param orderID
     * @return Returns an order based on the 'orderID' variable.
     * @throws RemoteException
     * @throws SQLException
     */
    @Override
    public Order getOrderByID(int orderID) throws RemoteException, SQLException {
        getOrdersTable();
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

