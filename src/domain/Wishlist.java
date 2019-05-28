package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Wishlist implements Serializable {

	private List<Product> products;

	public Wishlist() {
		products = new ArrayList<>();
	}

	public void addProduct(Product product){
		products.add(product);
	}

	public void removeProduct(Product product){
		products.remove(product);
	}

	public int size() {
		return products.size();
	}

	public Product getProduct(int index) {
		return products.get(index);
	}

	public List<Product> getAllProducts() {
		return products;
	}
}
