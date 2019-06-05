package server;

import domain.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface RServer extends Remote {

    public Connection connect() throws RemoteException,SQLException;
    public void close() throws RemoteException,SQLException;

    public Product getProduct(Product product) throws RemoteException, SQLException;
    public Product getProduct(int index) throws RemoteException, SQLException;
    public List<Product> getProductsTable() throws RemoteException, SQLException, ClassNotFoundException;
    public List<Order> getOrdersTable() throws RemoteException, SQLException;

    void addProduct(Product product) throws RemoteException, SQLException;
    void addOrder(Order order) throws RemoteException, SQLException;
    void updateProduct(Product product, String columnToUpdate,String newValue) throws RemoteException, SQLException;

    void purchase(Order order) throws RemoteException, SQLException;

    public Order getOrderByID(int orderID) throws RemoteException, SQLException;




}
