package server;

import domain.*;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RServer extends Remote {

    public Product getProduct(Product product) throws RemoteException;
    public ArrayList<Product> getProducts(int amount) throws RemoteException;

    public Categories getCategory(Categories category) throws RemoteException;
   // public void addCategory(Categories category);

    public void addProductToShoppingBag(ShoppingBag shoppingBag, Product product) throws RemoteException;

    public void removeFromShoppingBag(Product product) throws RemoteException;


    void purchase(String name, String adress, int phone);

    public Order getOrderByID(int orderID) throws RemoteException;

/*
    public void addOrderToArchive(Order order);
    public Archive getAllOrdersFromArchive(Archive archive);
    public void addProductToCategory(Categories category, Product product);

    public ShoppingBag getContentsOfShoppingBag(ShoppingBag shoppingBag);
    public void addProductToWishlist(Wishlist wishlist, Product product);
    public Wishlist getWishlist(Wishlist wishlist);
*/


}
