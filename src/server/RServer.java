package server;

import domain.*;

import java.rmi.Remote;
import java.util.ArrayList;

public interface RServer extends Remote {

    public Product getProduct(Product product);
    public ArrayList<Product> getProducts(int amount);

    public Categories getCategory(Categories category);
    public void addCategory(Categories category);
//    public void addProductToCategory(Categories category, Product product);

    public Order getOrder(Order order);
    public void getOrderByID(int orderID);

/*
    public void addOrderToArchive(Order order);
    public Archive getAllOrdersFromArchive(Archive archive);
*/

/*
    public void addProductToShoppingBag(ShoppingBag shoppingBag, Product product);
    public ShoppingBag getContentsOfShoppingBag(ShoppingBag shoppingBag);

    public void addProductToWishlist(Wishlist wishlist, Product product);
    public Wishlist getWishlist(Wishlist wishlist);
*/

}
