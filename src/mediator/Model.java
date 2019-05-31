package mediator;

import domain.*;

import java.beans.PropertyChangeListener;

import java.util.ArrayList;

public interface Model {

    ArrayList<Product> getProducts(int amount);
    Product getProduct(Product product);
    Categories getCategory(Categories category);
    int getOrderID(Order order);

    Order getOrderByID(int ID);

    ArrayList<Product> getArrayOfWishlist();

    Wishlist getWishlist();

    ShoppingBag getShoppingBag();

    ArrayList<Product> getBag();

    void addToWishlist(Product product);
    void addToShoppingbag(Product product);
    void removeFromWishlist(Product product);
    void removeFromShoppingBag(Product product);

    void increaseDecrease(String value, int index);

    void purchase(String name, String adress, int phone);

    void addListener(String eventName, PropertyChangeListener listener);
    void addProduct(Product product);
}
