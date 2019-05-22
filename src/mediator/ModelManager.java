package mediator;

import client.Client;
import domain.Categories;
import domain.Product;
import domain.*;

import java.util.ArrayList;
import domain.ShoppingBag;
import domain.Wishlist;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model {

	private Client client;
	private Product product;
	private Products productsList;
	private Categories category;
	private Order order;
	private Wishlist wish;
	private ShoppingBag bag;
    private PropertyChangeSupport changeSupport;

	public ModelManager(){
        changeSupport = new PropertyChangeSupport(this);
        wish = new Wishlist();
        bag = new ShoppingBag();
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
		Categories temp_category = new Categories(category.getCategoryID(),category.getCategoryName());

		for (int i = 0; i <productsList.size() ; i++) {
			temp_category.addProduct(productsList.getProduct(i));
		}

		return temp_category;
	}



	@Override
	public void addToWishlist(Product product) {
		wish.addProduct(product);
        changeSupport.firePropertyChange("AddWish",product,product.getName());
	}

	@Override
	public void addToShoppingbag(Product product) {
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
	public void purchase( String name, String adress, int phone) {
		order =  new Order(bag,name,adress,phone);
		changeSupport.firePropertyChange("Purchase",order,order.getOrderID());
		bag.emptyBag();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(eventName,listener);
    }
}
