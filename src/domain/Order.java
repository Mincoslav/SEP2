package domain;

import model.ModelManager;

public class Order {

	private ShoppingBag shoppingBag;
	private int orderID;
	private String costumerName;
	private String adress;
	private int phone;

	public Order(ShoppingBag shoppingBag, int orderID, String costumerName, String adress, int phone) {
		this.shoppingBag = shoppingBag;
		this.orderID = orderID;
		this.costumerName = costumerName;
		this.adress = adress;
		this.phone = phone;

	}



}
