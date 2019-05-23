package server;

import domain.*;
import mediator.Model;
import mediator.ModelManager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIServer implements RServer {

	private Model manager;

	public RMIServer() throws RemoteException {
		manager = new ModelManager();
		UnicastRemoteObject.exportObject(this,0);
	}

	@Override
	public Product getProduct(Product product) {
		Product temp_product = manager.getProduct(product);

		return temp_product;
	}

	@Override
	public ArrayList<Product> getProducts(int amount) {
		return manager.getProducts(amount);
	}

	@Override
	public Categories getCategory(Categories category) {
		return manager.getCategory(category);
	}

	@Override
	public void addProductToShoppingBag(ShoppingBag shoppingBag, Product product) {
		manager.addToShoppingbag(product);
	}

	@Override
	public void removeFromShoppingBag(Product product) {
		manager.removeFromShoppingBag(product);
	}



	@Override
	public void purchase(String name, String adress, int phone) {
		manager.purchase(name,adress,phone);
	}

	@Override
	public Order getOrderByID(int orderID) {
		Order temp_order = manager.getOrderByID(orderID);

		ShoppingBag empty_shoppingBag = new ShoppingBag();
		Order empty_order = new Order(empty_shoppingBag,"","",0);

		if (temp_order == null){
			System.out.println("The order doesn't exist.");
			return empty_order;
		}
		return temp_order;
	}
/*
	@Override
	public void addProductToShoppingBag(ShoppingBag shoppingBag, Product product) {

	}

	@Override
	public ShoppingBag getContentsOfShoppingBag(ShoppingBag shoppingBag) {
		return null;
	}

	@Override
	public void addProductToWishlist(Wishlist wishlist, Product product) {

	}

	@Override
	public Wishlist getWishlist(Wishlist wishlist) {
		return null;
	}
*/


}
