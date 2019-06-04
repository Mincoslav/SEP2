package mediator;

import client.RMIClient;
import client.RemoteClient;
import domain.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public ModelManager() throws RemoteException, NotBoundException, MalformedURLException {
        changeSupport = new PropertyChangeSupport(this);
        wish = new Wishlist();
        bag = new ShoppingBag();
        order =  new Order(bag,"","",0);
        productsList = new Products();
        productsList = new Products();
        orders = new ArrayList<>();
        client = new RMIClient();
    }


	@Override
	public List<Product> getProducts() throws SQLException, RemoteException, ClassNotFoundException {
		List<Product> temp_products = client.getProducts();

		return temp_products;
	}

	@Override
	public Product getProduct(Product product) throws RemoteException, SQLException {
		Product temp_product = client.getProduct(product);

		return temp_product;
	}

	@Override
	public Categories getCategory(Categories category) throws SQLException, RemoteException, ClassNotFoundException {
		Categories temp_category = client.getCategory(category);

		return temp_category;
	}

	@Override
	public int getOrderID(Order order) throws RemoteException {
		return	client.getOrderID(order);
	}

	@Override
	public Order getOrderByID(int ID) throws RemoteException, SQLException {
		return client.getOrderByID(ID);
	}

	@Override
	public List<Product> getArrayOfWishlist() {
		return wish.getAllProducts();
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
	public List<Product> getBag() {
		return bag.getAllProducts();
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
		ShoppingBag orderBag ;
		orderBag = bag.copy();
		order =  new Order(orderBag,name,adress,phone);

		orders.add(order);
		try {
			client.purchase(order);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		changeSupport.firePropertyChange("Purchase",order,order.getOrderID());
		/*for(int i = 0; i< order.getShoppingBag().size();i++){
			productsList.getProduct(order.getShoppingBag().getProduct(i))
					.setQuantity
					(order.getShoppingBag().getProduct(i).getQuantity()
					-order.getShoppingBag().getProduct(i).getPurchasedQuantity());
			}*/
		/*System.out.println(productsList.getProduct(0).getPurchasedQuantity());
		System.out.println(productsList.getProduct(0).getQuantity());*/
		bag.emptyBag();
		System.out.println(bag.size());
		System.out.println(orderBag.subTotal());
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
