package mediator;

import com.sun.org.apache.xpath.internal.operations.Or;
import domain.Categories;
import domain.Order;
import domain.Product;

import java.beans.PropertyChangeListener;

import java.util.ArrayList;

public interface Model {

    ArrayList<Product> getProducts(int amount);
    Product getProduct(Product product);
    Categories getCategory(Categories category);
    int getOrderID(Order order);

    Order getOrderByID(int ID);

    void addToWishlist(Product product);
    void addToShoppingbag(Product product);
    void removeFromWishlist(Product product);
    void removeFromShoppingBag(Product product);
    void purchase(String name, String adress, int phone);

    void addListener(String eventName, PropertyChangeListener listener);
}
