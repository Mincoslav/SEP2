package server;

import domain.*;
import mediator.Model;
import mediator.ModelManager;
import server.database.Database;
import server.database.DatabaseCon;
import server.database.DatabaseConnection;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RMIServer implements RServer, DatabaseCon {

	private Model manager;
	private Database database;


	public RMIServer() throws RemoteException {
		database = new Database();
		manager = new ModelManager();

		UnicastRemoteObject.exportObject(this,0);
	}

	@Override
	public Product getProduct(Product product) throws SQLException {
		String tempProductName = product.getName();
		PreparedStatement statement = database.connect().prepareStatement("SELECT * FROM products WHERE name ="+ tempProductName);
		ResultSet resultSet = statement.executeQuery();
		String name = resultSet.getString("name");
		int stock = resultSet.getInt("stock");
		int categoryID = resultSet.getInt("categoryID");
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


	//creates order in the database and reduces the amounts in stock
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

	@Override
	public List<Product> getProducts() throws RemoteException, ClassNotFoundException, SQLException {
		return null;
	}

	@Override
	public List<Order> getOrders() throws RemoteException {
		return null;
	}

	@Override
	public List<Categories> getCategory() throws RemoteException {
		return null;
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
