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
import java.util.ArrayList;

public class RMIClient implements RemoteClient {

	private Model manager;

	private RServer server;

	public RMIClient() throws RemoteException, MalformedURLException, NotBoundException {
		manager = new ModelManager();
		server = (RServer) Naming.lookup("rmi://localhost:1099/shopping");
	}

	@Override
	public Product getProduct(Product product) {
		return manager.getProduct(product);
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
	public Order getOrderByID(int orderID) {
		Order temp_order = manager.getOrderByID(orderID);

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
	public int getOrderID(Order order) throws RemoteException {
		return order.getOrderID();
	}

}
