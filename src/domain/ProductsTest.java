package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductsTest {

    private Products products = new Products(3);
    private Product product = new Product("This Sweater", "www.com", 3, 6, 100, 200, false, "long", 1);

    @Test
    public void addProduct() {
        products.addProduct(product);
        assertEquals(1, products.size());
    }

    @Test
    public void removeProduct() {
        products.addProduct(product);
        products.removeProduct(product);
        assertEquals(0, products.size());
    }

    @Test
    public void getProduct() {
        products.addProduct(product);
       assertEquals(product, products.getProduct(0));
    }

    @Test
    public void getProduct2() {
        products.addProduct(product);
        assertEquals(product, products.getProduct(product));

    }

    @Test
    public void size() {
        products.addProduct(product);
        products.addProduct(product);
        assertEquals(2, products.size());
    }
}