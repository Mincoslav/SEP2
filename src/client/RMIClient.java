package client;

import com.sun.org.apache.regexp.internal.RE;
import domain.Categories;
import domain.Order;
import domain.Product;
import mediator.Model;
import server.RServer;

import java.util.ArrayList;

public class RMIClient implements RemoteClient {

	private Model model;

	@Override
	public Product getProduct(Product product) {
		return null;
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		return null;
	}

	@Override
	public Categories getCategory(Categories category) {
		return null;
	}

	@Override
	public Order getOrder(Order order) {
		return null;
	}

	@Override
	public void getOrderByID(int orderID) {

	}

	public static void main(String[] args) {

	}
}
