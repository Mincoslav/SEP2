package client;

import domain.Categories;
import domain.Order;
import domain.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface RemoteClient extends Remote {

    Product getProduct(Product product) throws RemoteException, SQLException;
    List<Product> getProducts() throws RemoteException, ClassNotFoundException, SQLException;

    Categories getCategory(Categories category) throws RemoteException, ClassNotFoundException, SQLException;

    Order getOrderByID(int orderID) throws RemoteException, SQLException;
    int getOrderID(Order order) throws RemoteException;
    void addProduct(Product product) throws RemoteException,SQLException;

    void removeProduct(Product product) throws RemoteException, SQLException;

    void purchase(Order order) throws RemoteException, SQLException;


}
