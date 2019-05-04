package domain;

import java.util.ArrayList;

public class Wishlist {

	private ArrayList<Product> products;

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
}
