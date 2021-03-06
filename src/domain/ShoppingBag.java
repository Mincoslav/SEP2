package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingBag implements Serializable {

	private List<Product> products;

	public ShoppingBag() {
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

	public  void changeQuantity(int index,int input){
		getProduct(index).setPurchasedQuantity(input);
	}

	public int subTotal() {
		int total = 0;
		for(int i = 0; i < size(); i++){
			total += getProduct(i).getPrice()*getProduct(i).getPurchasedQuantity();
		}
		return total;
	}

	public void emptyBag() {
		products.clear();
	}

	public ShoppingBag copy() {
		ShoppingBag bag = new ShoppingBag();
		for(int i = 0;i<size();i++){
			bag.addProduct(getProduct(i));
		}
		return bag;
	}

	public List<Product> getAllProducts() {
		return products;
	}

	@Override
	public String toString() {
		return "ShoppingBag{" +
				"products=" + products +
				'}';
	}

}
