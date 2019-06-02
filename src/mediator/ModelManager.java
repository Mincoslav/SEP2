package mediator;

import client.RemoteClient;
import domain.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model {

	private RemoteClient client;
	private Product product;
	private Products productsList;
	private Categories category;
	private Order order;
	private Wishlist wish;
	private ShoppingBag bag;
    private PropertyChangeSupport changeSupport;
    private ArrayList<Order> orders;

	public ModelManager(){
        changeSupport = new PropertyChangeSupport(this);
        wish = new Wishlist();
        bag = new ShoppingBag();
        order =  new Order(bag,"","",0);
        productsList = new Products();
        productsList = new Products();
        orders = new ArrayList<>();
    }


	@Override
	public ArrayList<Product> getProducts(int amount) {
		ArrayList<Product> temp_products = new ArrayList<>(amount);

		for (int i = 0; i <= amount ; i++) {
			temp_products.add(productsList.getProduct(i));
		}

		return temp_products;
	}

	@Override
	public Product getProduct(Product product) {
		Product temp_product = productsList.getProduct(product);

		return temp_product;
	}

	@Override
	public Categories getCategory(Categories category) {
		Categories temp_category = new Categories(category.getCategoryID(), category.getCategoryName());

		for (int i = 0; i < productsList.size(); i++) {
			temp_category.addProduct(productsList.getProduct(i));
		}

		return temp_category;
	}

	@Override
	public int getOrderID(Order order) {
		return order.getOrderID();
	}

	@Override
	public Order getOrderByID(int ID) {
		ShoppingBag empty_shoppingBag = new ShoppingBag();
		Order empty_order = new Order(empty_shoppingBag,"","",0);

		if (!(order.getOrderID() == ID)){
			System.out.println("Order with this ID doesn't exist");
			return empty_order;
		}
		else {
			return order;
		}

	}

	@Override
	public ArrayList<Product> getArrayOfWishlist() {
		return (ArrayList<Product>) wish.getAllProducts();
	}

	@Override
	public Wishlist getWishlist() {
		return wish;
	}

	@Override
	public void getAProduct(Product product){
		changeSupport.firePropertyChange("Product",product,product.getName());
	}

	@Override
	public ShoppingBag getShoppingBag() {
		return bag;
	}

	@Override
	public ArrayList<Product> getBag() {
		return (ArrayList<Product>) bag.getAllProducts();
	}

	@Override
	public void addToWishlist(Product product) {
		wish.addProduct(product);
        changeSupport.firePropertyChange("AddWish",product,product.getName());
	}

	@Override
	public void addToShoppingbag(Product product) {
		product.setPurchasedQuantity(1);
	    bag.addProduct(product);
        changeSupport.firePropertyChange("AddBag",product,product.getName());
	}

	@Override
	public void removeFromWishlist(Product product) {
	    wish.removeProduct(product);
        changeSupport.firePropertyChange("RemoveWish",product,product.getName());
	}

	@Override
	public void removeFromShoppingBag(Product product) {
        bag.removeProduct(product);
        changeSupport.firePropertyChange("RemoveBag",product,product.getName());
	}

	@Override
	public void increaseDecrease(String value, int index){
		int temp = bag.getProduct(index).getPurchasedQuantity();
		Product product = bag.getProduct(index);
		if(temp == 1 && value.equals("decrease")){
			bag.removeProduct(bag.getProduct(index));
		}else if(value.equals("decrease")){
			bag.changeQuantity(index,bag.getProduct(index).getPurchasedQuantity()-1);
		}else if(value.equals("increase")){
			bag.changeQuantity(index,bag.getProduct(index).getPurchasedQuantity()+1);
		}
		changeSupport.firePropertyChange("IncreaseDecrease",product,index);
	}

	@Override
	public void purchase( String name, String adress, int phone) {
		order =  new Order(bag,name,adress,phone);
		orders.add(order);
		changeSupport.firePropertyChange("Purchase",order,order.getOrderID());
		for(int i = 0; i< order.getShoppingBag().size();i++){
			productsList.getProduct(order.getShoppingBag().getProduct(i)).setQuantity(order.getShoppingBag().getProduct(i).getQuantity() -order.getShoppingBag().getProduct(i).getPurchasedQuantity());
		}
		System.out.println(productsList.getProduct(0).getPurchasedQuantity());
		System.out.println(productsList.getProduct(0).getQuantity());
		bag.emptyBag();
		System.out.println(bag.size());
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(eventName,listener);
    }

	@Override
	public void addProduct(Product product) {
		productsList.addProduct(product);

	}

}
