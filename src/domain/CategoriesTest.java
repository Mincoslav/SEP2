package domain;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CategoriesTest {

    private Categories categories = new Categories(1, "Shoes");
    private Product product = new Product("Deez Shoes", "d.com", 123, 5, 100, 300, true, "comfortable", 2);

    @Test
    public void addProduct() {
        categories.addProduct(product);
        assertEquals(1, categories.size());
    }

    @Test
    public void removeProduct() {
        categories.addProduct(product);
        categories.removeProduct(product);
        assertEquals(0, categories.size());
    }

    @Test
    public void getCategoryProducts() {
        categories.addProduct(product);
        // ?
    }

    @Test
    public void getCategoryID() {
        categories.addProduct(product);
        assertEquals(1, categories.getCategoryID());
    }

    @Test
    public void getCategoryName() {
        categories.addProduct(product);
        assertEquals("Shoes", categories.getCategoryProducts());
    }

    @Test
    public void size() {
        categories.addProduct(product);
        assertEquals(1, categories.size());
    }

    @Test
    public String toString() {
        categories.addProduct(product);
        return categories.toString();
    }
}