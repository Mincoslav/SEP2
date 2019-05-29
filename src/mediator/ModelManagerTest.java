package mediator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModelManagerTest {

    private ModelManager modelManager = new ModelManager();

    @Test
    public void getProducts() {
        assertEquals(modelManager.getProducts(2));
    }

    @Test
    public void getProduct() {
    }

    @Test
    public void getCategory() {
    }

    @Test
    public void getOrderID() {
    }

    @Test
    public void getOrderByID() {
    }

    @Test
    public void getArrayOfWishlist() {
    }

    @Test
    public void getWishlist() {
    }

    @Test
    public void getShoppingBag() {
    }

    @Test
    public void getBag() {
    }

    @Test
    public void addToWishlist() {
    }

    @Test
    public void addToShoppingbag() {
    }

    @Test
    public void removeFromWishlist() {
    }

    @Test
    public void removeFromShoppingBag() {
    }

    @Test
    public void purchase() {
    }

    @Test
    public void addListener() {
    }
}