package server;

import domain.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RServer extends Remote {

    public void getTable(String tableName);
    public Connection connect() throws RemoteException,SQLException;
    public void close() throws RemoteException,SQLException;

    public Product getProduct(Product product) throws RemoteException, SQLException;
    public Product getProduct(int index) throws RemoteException, SQLException;
    public List<Product> getProducts() throws RemoteException, SQLException, ClassNotFoundException;
    public List<Order> getOrders() throws RemoteException, SQLException;

    void addProduct(Product product) throws RemoteException, SQLException;
    void addOrder(Order order) throws RemoteException, SQLException;
    void updateProduct(Product product, String columnToUpdate,String newValue) throws RemoteException, SQLException;

    void purchase(String name, String adress, int phone) throws RemoteException, SQLException;

    public Order getOrderByID(int orderID) throws RemoteException, SQLException;

    public void addProductToShoppingBag(Product product) throws RemoteException;



}
