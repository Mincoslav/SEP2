package domain;

import java.io.Serializable;

public class Order implements Serializable {

	private ShoppingBag shoppingBag;
	private int orderID;
	private String costumerName;
	private String adress;
	private int phone;

	public Order(ShoppingBag shoppingBag, String costumerName, String adress, int phone) {
		this.shoppingBag = shoppingBag;
		this.orderID = 0;
		this.costumerName = costumerName;
		this.adress = adress;
		this.phone = phone;
	}

	public ShoppingBag getShoppingBag() {
		return shoppingBag;
	}

	public int getOrderID() {
		return orderID;
	}

	public String getCostumerName() {
		return costumerName;
	}

	public String getAdress() {
		return adress;
	}

	public int getPhone() {
		return phone;
	}


}
