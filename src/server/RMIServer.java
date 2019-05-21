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

		return null;
	}

	@Override
	public Categories getCategory(Categories category) {
		return null;
	}

	@Override
	public void addCategory(Categories category) {

	}

	@Override
	public Order getOrder(Order order) {
		return null;
	}

	@Override
	public void getOrderByID(int orderID) {

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

	public static void main(String[] args) {
		try {
			System.out.println("Starting server...");

			//Locating the port and creating the server instance
			Registry registry = LocateRegistry.createRegistry(1099);
			RServer server = new RMIServer();
			Naming.rebind("shopping", server);

			System.out.println("Server started.\nReady for clients.");

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
