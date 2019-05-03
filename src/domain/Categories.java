package domain;

import java.util.ArrayList;

public class Categories {


	ArrayList<Product> categoryProducts;
	int categoryID;
	String categoryName;

	public Categories(int categoryID, String categoryName) {
		categoryProducts = new ArrayList<>();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}

	public void addProduct(Product product){
		if(this.categoryID== product.getCategoryID())
			categoryProducts.add(product);
	}

	public void removeProduct(Product product){
		int tempVariableCategoryID = 0;
		for (int i = 0; i < categoryProducts.size(); i++) {
			Product tempVariable = categoryProducts.get(i);
			if (tempVariable.equals(product)) {
				 tempVariableCategoryID = tempVariable.getCategoryID();
				 break;
			}
		}
		if (this.categoryID == categoryProducts.get(tempVariableCategoryID).getCategoryID()){
			categoryProducts.remove(tempVariableCategoryID);
		}
	}
}


