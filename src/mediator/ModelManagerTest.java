package mediator;

import domain.Categories;
import domain.Order;
import domain.Product;
import domain.ShoppingBag;
import org.junit.Test;

import java.beans.PropertyChangeListener;

import static org.junit.Assert.*;

public class ModelManagerTest {

    private ModelManager modelManager = new ModelManager();
    private Product product = new Product("This Sweater", "www.com", 3, 6, 100, 200, false, "long", 1);
    private Categories category = new Categories(1,"Shoes");
    private ShoppingBag bag = new ShoppingBag();
    private Order order = new Order(bag, "Max", "Main Street", 123);
    private PropertyChangeListener propertyChangeListener = evt -> {

    };

    @Test
    public void getProducts() {
        assertEquals(3, modelManager.getProducts(3).size());

    }

    @Test
    public void getProduct() {
        assertEquals(product, modelManager.getProduct(product));
    }

    @Test
    public void getCategory() {
        assertEquals(category, modelManager.getCategory(category));
    }

    @Test
    public void getOrderID() {
        assertEquals(order.getOrderID(), modelManager.getOrderID(order));
    }

    @Test
    public void getOrderByID() {
        assertEquals("", modelManager.getOrderByID(0).getAdress());
    }

    @Test
    public void getArrayOfWishlist() {
        assertNotNull(modelManager.getArrayOfWishlist());
    }

    @Test
    public void getWishlist() {
        assertNull(modelManager.getWishlist());
    }

    @Test
    public void getShoppingBag() {
        assertTrue(modelManager.getShoppingBag() instanceof ShoppingBag);
    }

    @Test
    public void getBag() {
        assertNotNull(modelManager.getBag());
    }

    @Test
    public void addToWishlist() {
        modelManager.addToWishlist(product);
        assertNotNull(modelManager.getWishlist());
    }

    @Test
    public void addToShoppingbag() {
        modelManager.addToShoppingbag(product);
        assertNotNull(modelManager.getShoppingBag());
    }

    @Test
    public void removeFromWishlist() {
        modelManager.addToWishlist(product);
        modelManager.removeFromWishlist(product);
        assertNull(modelManager.getWishlist());
    }

    @Test
    public void removeFromShoppingBag() {
        modelManager.addToShoppingbag(product);
        modelManager.removeFromShoppingBag(product);
        assertNull(modelManager.getShoppingBag());
    }

    @Test
    public void purchase() {
        modelManager.purchase("John", "My Street", 123);
        assertEquals(0, modelManager.getShoppingBag().size());
    }

    @Test
    public void addListener() {
        modelManager.addListener("Purchase", propertyChangeListener);
    }
};
