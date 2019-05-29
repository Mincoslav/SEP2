package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class WishlistTest {

    private Wishlist list = new Wishlist();
    private Product product = new Product("DX Shirt", "www.com", 1, 1, 30, 400, false, "comfortable", 7);

    @Test
    public void addProduct() {
        list.addProduct(product);
        assertEquals(product, list.getProduct(0));
    }

    @Test
    public void removeProduct() {
        list.addProduct(product);
        list.removeProduct(product);
        assertEquals(0, list.size());
    }

    @Test
    public void size() {
        list.addProduct(product);
        list.addProduct(product);
        assertEquals(2, list.size());
    }

    @Test
    public void getProduct() {
        list.addProduct(product);
        assertEquals(product, list.getProduct(0));
    }

    @Test
    public void getAllProducts() {
        list.addProduct(product);
        list.addProduct(product);

        // ?
    }
}