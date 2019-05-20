package client;

import domain.Categories;
import domain.Order;
import domain.Product;

import java.rmi.Remote;
import java.util.ArrayList;

public interface RemoteClient extends Remote {

    public Product getProduct(Product product);
    public ArrayList<Product> getAllProducts();

    public Categories getCategory(Categories category);

    public Order getOrder(Order order);
    public void getOrderByID(int orderID);

}
