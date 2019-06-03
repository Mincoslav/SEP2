package mediator;

import domain.*;

import java.beans.PropertyChangeListener;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface Model {

    List<Product> getProducts() throws SQLException, RemoteException, ClassNotFoundException;
    Product getProduct(Product product) throws RemoteException, SQLException;
    Categories getCategory(Categories category) throws SQLException, RemoteException, ClassNotFoundException;
    int getOrderID(Order order) throws RemoteException;

    Order getOrderByID(int ID) throws RemoteException, SQLException;

    List<Product> getArrayOfWishlist();

    Wishlist getWishlist();

    void getAProduct(Product product);

    ShoppingBag getShoppingBag();

    List<Product> getBag();

    void addToWishlist(Product product);
    void addToShoppingbag(Product product);
    void removeFromWishlist(Product product);
    void removeFromShoppingBag(Product product);

    void increaseDecrease(String value, int index);

    void purchase(String name, String adress, int phone) throws RemoteException, SQLException;

    void addListener(String eventName, PropertyChangeListener listener);
    void addProduct(Product product);
}
