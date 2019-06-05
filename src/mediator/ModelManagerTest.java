package mediator;

import domain.Categories;
import domain.Order;
import domain.Product;
import domain.ShoppingBag;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ModelManagerTest {

    private ModelManager modelManager;

    {
        try {
            modelManager = new ModelManager();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private Product product = new Product("This Sweater", "www.com", 3, 6, 100, 200, false, "long", 1);
    private Categories category = new Categories(1, "Shoes");
    private ShoppingBag bag = new ShoppingBag();
    private Order order = new Order(bag, "Max", "Main Street", 123);

    @Before
    public void connect() {

    }

    @After
    public void close() {

    }

    @Test
    public void getProducts() {
        try {
            modelManager.addProduct(product);
            assertNotNull(modelManager.getProducts());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getProduct() {
        try {
            modelManager.addProduct(product);
            assertEquals(product, modelManager.getProduct(product));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCategory() {
        try {
            assertEquals(category, modelManager.getCategory(category));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getOrderID() {
        try {
            assertEquals(order.getOrderID(), modelManager.getOrderID(order));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getArrayOfWishlist() {
        assertNotNull(modelManager.getArrayOfWishlist());
    }

    @Test
    public void getWishlist() {
        modelManager.addToWishlist(product);
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
}
