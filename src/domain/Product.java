package domain;

import model.ModelManager;

public class Product {

	private ShoppingBag shoppingBag;

	private ModelManager modelManager;

	int categoryID;
	String name;

	public Product(int categoryID, String name) {
		this.categoryID = categoryID;
		this.name = name;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public String getName() {
		return name;
	}
}

