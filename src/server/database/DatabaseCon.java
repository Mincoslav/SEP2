package server.database;

import domain.Categories;
import domain.Order;
import domain.Product;
import domain.ShoppingBag;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseCon extends Remote {

    public List<Product> getProducts() throws RemoteException, ClassNotFoundException, SQLException;
    public List<Order> getOrders() throws RemoteException, SQLException;
    public List<Categories> getCategory(Categories category) throws RemoteException, SQLException;
    public Product getProduct(Product product) throws RemoteException, SQLException;

    public void removeFromShoppingBag(Product product) throws RemoteException, SQLException;

    public void purchase(String name, String adress, int phone)throws RemoteException, SQLException;

    public Order getOrderByID(int orderID) throws RemoteException, SQLException;

    public void addProductToShoppingBag(ShoppingBag shoppingBag, Product product) throws RemoteException, SQLException;

}
