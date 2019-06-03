package client;

import com.sun.org.apache.regexp.internal.RE;
import domain.Categories;
import domain.Order;
import domain.Product;
import domain.ShoppingBag;
import mediator.Model;
import mediator.ModelManager;
import server.RServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RMIClient implements RemoteClient {

	private Model manager;

	private RServer server;

	public RMIClient() throws RemoteException, MalformedURLException, NotBoundException {
		server = (RServer) Naming.lookup("rmi://localhost:1099/shopping");
	}

	@Override
	public Product getProduct(Product product) throws RemoteException, SQLException {
		return server.getProduct(product);
	}

	@Override
	public List<Product> getProducts() throws RemoteException, ClassNotFoundException, SQLException {
		return server.getProducts();
	}


	@Override
	public Categories getCategory(Categories category) throws ClassNotFoundException, RemoteException, SQLException {
		int id = category.getCategoryID();

		for (int i = 0; i < server.getProducts().size() ; i++) {

			category.addProduct(server.getProduct(i));
		}
		return category;
	}

	@Override
	public Order getOrderByID(int orderID) throws RemoteException, SQLException {
		return server.getOrderByID(orderID);
	}

	@Override
	public int getOrderID(Order order) throws RemoteException {
		return order.getOrderID();
	}

	@Override
	public void purchase(Order order) throws RemoteException, SQLException {
		server.purchase(order);
	}

}
