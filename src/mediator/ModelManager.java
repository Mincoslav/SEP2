package mediator;

import client.Client;
import domain.Categories;
import domain.Product;
import domain.*;

import java.util.ArrayList;

public class ModelManager implements Model {

	private Client client;
	private Product product;
	private Products productsList;
	private Categories category;
	private Order order;
	private ShoppingBag shoppingBag;
	private Wishlist wishlist;




	@Override
	public ArrayList<Product> getProducts(int amount) {
		ArrayList<Product> temp_products = new ArrayList<>(amount);

		for (int i = 0; i <= amount ; i++) {
			temp_products.add(productsList.getProduct(i));
		}

		return temp_products;
	}

	@Override
	public Product getProduct(Product product) {
		Product temp_product = productsList.getProduct(product);

		return temp_product;
	}

	@Override
	public Categories getCategory(Categories category) {
		Categories temp_category = new Categories(category.getCategoryID(),category.getCategoryName());

		for (int i = 0; i <productsList.size() ; i++) {
			temp_category.addProduct(productsList.getProduct(i));
		}

		return temp_category;
	}



	@Override
	public void addToWishlist(Product product) {

	}

	@Override
	public void addToShoppingbag(Product product) {

	}

	@Override
	public void removeFromWishlist(Product product) {

	}

	@Override
	public void removeFromShoppingBag(Product product) {

	}

	@Override
	public void purchase() {

	}
}
