package server;

import client.RMIClient;
import client.RemoteClient;
import domain.*;
import mediator.Model;
import mediator.ModelManager;
import server.database.DatabaseAccess;
import server.database.DatabaseCon;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RMIServer implements RServer {

	private Model manager;
	private DatabaseCon databaseAccess;



	public RMIServer() throws RemoteException, MalformedURLException, NotBoundException {
		UnicastRemoteObject.exportObject(this,0);
		databaseAccess = new DatabaseAccess();

	}

	@Override
	public void getTable(String tableName) throws RemoteException {
		databaseAccess.getTable(tableName);
	}

	@Override
	public Connection connect() throws RemoteException, SQLException {
		Connection connection = databaseAccess.connect();

		return connection;
	}

	@Override
	public void close() throws RemoteException, SQLException {
		databaseAccess.close();
	}

	@Override
	public Product getProduct(Product product) throws SQLException, RemoteException {
		Product temp_product =  databaseAccess.getProduct(product);
		return temp_product;
	}

	@Override
	public Product getProduct(int index) throws RemoteException, SQLException {
		return databaseAccess.getProduct(index);
	}

	@Override
	public List<Product> getProducts() throws SQLException, RemoteException, ClassNotFoundException {
		List<Product> productList = databaseAccess.getProducts();
		return productList;
	}

	//creates order in the database and reduces the amounts in stock
	@Override
	public void purchase(Order order) throws RemoteException, SQLException {

		ArrayList<Product> products = (ArrayList<Product>) order.getShoppingBag().getAllProducts();
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			int amount = product.getPurchasedQuantity();
			databaseAccess.purchase(amount,product);
		}

	}

	@Override
	public Order getOrderByID(int orderID) throws RemoteException, SQLException {

		Order temp_order = databaseAccess.getOrderByID(orderID);
		ShoppingBag empty_shoppingBag = new ShoppingBag();
		Order empty_order = new Order(empty_shoppingBag,"","",0);

		if (temp_order == null){
			System.out.println("The order doesn't exist.");
			return empty_order;
		}
		else
			return temp_order;
	}

	@Override
	public List<Order> getOrders() throws RemoteException, SQLException {
		return databaseAccess.getOrders();
	}

	@Override
	public void addProduct(Product product) throws RemoteException, SQLException {
		databaseAccess.addProduct(product);
	}

	@Override
	public void addOrder(Order order) throws RemoteException, SQLException {
		databaseAccess.addOrder(order);
	}

	@Override
	public void updateProduct(Product product, String columnToUpdate, String newValue) throws RemoteException, SQLException {
		databaseAccess.updateProduct(product,columnToUpdate,newValue);
	}

}
