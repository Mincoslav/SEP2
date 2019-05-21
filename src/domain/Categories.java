package domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Categories implements Serializable {


	ArrayList<Product> categoryProducts;
	int categoryID;
	String categoryName;

	public Categories(int categoryID, String categoryName) {
		categoryProducts = new ArrayList<>();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}

	public void addProduct(Product product){
			categoryProducts.add(product);
	}

	public void removeProduct(Product product){
		categoryProducts.remove(product);
	}

	public ArrayList<Product> getCategoryProducts() {
		return categoryProducts;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public int size(){
		return categoryProducts.size();
	}

	@Override
	public String toString() {
		return "Categories{" +
				"categoryProducts=" + categoryProducts +
				", categoryID=" + categoryID +
				", categoryName='" + categoryName + '\'' +
				'}';
	}
}


