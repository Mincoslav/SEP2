package client;

import domain.Categories;
import domain.Order;
import domain.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteClient extends Remote {

    Product getProduct(Product product) throws RemoteException;
    ArrayList<Product> getProducts(int amount) throws RemoteException;

    Categories getCategory(Categories category) throws RemoteException;

    Order getOrderByID(int orderID) throws RemoteException;
    int getOrderID(Order order) throws RemoteException;

}
