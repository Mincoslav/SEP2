package server.database;

import domain.Categories;
import domain.Order;
import domain.Product;
import domain.ShoppingBag;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseCon extends Remote {

    public void close() throws RemoteException;
    public List<Order> getOrdersTable() throws RemoteException, SQLException;
    public List<Product> getProductTable() throws RemoteException, SQLException;
    public Connection connect() throws RemoteException,SQLException;
    public Product getProduct(Product product) throws RemoteException, SQLException;
    public Product getProduct(int index) throws RemoteException,SQLException;


    void addProduct(Product product) throws RemoteException, SQLException;
    void addOrder(Order order) throws RemoteException, SQLException;
    void updateProduct(Product product, String columnToUpdate,String newValue) throws RemoteException, SQLException;


    public void purchase(int amount, Product product)throws RemoteException, SQLException;

    public Order getOrderByID(int orderID) throws RemoteException, SQLException;


}
