package domain;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable {

	private String name;
	private String imageLocation;

	private int productID;

	private int categoryID;
	private int quantity;
	private int purchasedQuantity;
	private boolean onSale;
	private String description;
	private double price;

	public Product(String name, String imageLocation,int productID, int categoryID, int quantity,double price, boolean onSale, String description,int purchasedQuantity) {
		this.name = name;
		this.imageLocation = imageLocation;
		this.productID = productID;
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

	public int getProductID() {
		return productID;
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
		this.purchasedQuantity = i;
	}

	public int getPurchasedQuantity() {
		return purchasedQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Image getImage() {
		Image image = new Image(imageLocation);
		return  image;
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

	@Override
	public String toString() {
		return "Product{" +
				"name='" + name + '\'' +
				", imageLocation='" + imageLocation + '\'' +
				", categoryID=" + categoryID +
				", quantity=" + quantity +
				", purchasedQuantity=" + purchasedQuantity +
				", onSale=" + onSale +
				", description='" + description + '\'' +
				", price=" + price +
				'}';
	}
}

