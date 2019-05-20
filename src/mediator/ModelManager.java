package mediator;

import client.Client;
import domain.Categories;
import domain.Product;

public class ModelManager implements Model {

	private Client client;


	@Override
	public Product getProducts(int amount) {
		return null;
	}

	@Override
	public Categories getCategory(Categories category) {
		return null;
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
