package domain;

import model.ModelManager;

import java.util.ArrayList;

public class Categories {

	private Product product;

	private int hi;

	private ModelManager modelManager;

	ArrayList<Product> products;
	int categoryID;
	String categoryName;

	public Categories(int categoryID, String categoryName) {
		products = new ArrayList<>();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}

	public void addProduct(Product product){
		if(this.categoryID== product.getCategoryID()){
			products.add(product);}
	}
}


