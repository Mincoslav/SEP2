package domain;

import java.util.ArrayList;

public class ShoppingBag {

	private ArrayList<Product> products;

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

	public  void changeQuantity(Product product,int input){
		product.setPurchasedQuantity(input);
	}

	public int subTotal() {
		int total = 0;
		for(int i = 0; i < size(); i++){
			total += getProduct(i).getPrice();
		}
		return total;
	}

}
