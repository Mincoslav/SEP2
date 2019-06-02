package domain;

import java.io.Serializable;
import java.util.Random;

public class Order implements Serializable {

	private ShoppingBag shoppingBag;
	private int orderID;
	private String costumerName;
	private String adress;
	private int phone;

	public Order(ShoppingBag shoppingBag, String costumerName, String adress, int phone) {
		this.shoppingBag = shoppingBag;
		this.orderID = getRandomIntegerBetweenRange(1000,100000);
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

	public static int getRandomIntegerBetweenRange(int min, int max){
		int x = (int)(Math.random()*((max-min)+1))+min;
		return x;
	}


	@Override
	public String toString() {
		return "Order{" +
				"shoppingBag=" + shoppingBag +
				", orderID=" + orderID +
				", costumerName='" + costumerName + '\'' +
				", adress='" + adress + '\'' +
				", phone=" + phone +
				'}';
	}
}
