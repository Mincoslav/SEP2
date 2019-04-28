package domain;

import java.util.Objects;

public class Product {

	private String name;
	private String imageLocation;
	private int categoryID;
	private int quantity;
	private int purchasedQuantity;
	private boolean onSale;
	private String description;
	private int price;


	public Product(String name, String imageLocation, int categoryID, int quantity, boolean onSale, String description,int purchasedQuantity) {
		this.name = name;
		this.imageLocation = imageLocation;
		this.categoryID = categoryID;
		this.price = price;
		this.quantity = quantity;
		this.onSale = onSale;
		this.description = description;
		this.purchasedQuantity = purchasedQuantity;
	}

	public int getCategoryID() {
		return categoryID;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isOnSale() {
		return onSale;
	}

	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPurchasedQuantity(int i) {
		purchasedQuantity = i;
	}

	public int getPurchasedQuantity() {
		return purchasedQuantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return getCategoryID() == product.getCategoryID() &&
				getQuantity() == product.getQuantity() &&
				isOnSale() == product.isOnSale() &&
				Objects.equals(getName(), product.getName()) &&
				Objects.equals(getImageLocation(), product.getImageLocation()) &&
				Objects.equals(getDescription(), product.getDescription());
	}

}

