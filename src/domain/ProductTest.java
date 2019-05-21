package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProductTest {

    Product product = new Product("Tshirt", "www.com", 2,2, 5, false, "shitty", 2);
    Product product0 = new Product("bluse", "www.",2,23, 100, true, "cool", 12);
    List<Product> expected = new ArrayList<Product>();

    @Test

    public void getCategoryID() {


        expected.add(product0);
        assertEquals(expected.get(0).getCategoryID(), 3);

    }

    @Test
    public void getName() {

        expected.add(product);
        assertEquals(expected.get(0).getName(), "Tshirt");


    }

    @Test
    public void setName() {
        expected.add(product);
        expected.get(0).setName("Meoww");
        assertEquals(expected.get(0).getName(), "Meoww");


    }

    @Test
    public void getImageLocation() {

        expected.add(product);
        assertEquals(expected.get(0).getImageLocation(), "www.com");
    }

    @Test
    public void setImageLocation() {
        expected.add(product);
        expected.get(0).setImageLocation("www.slslsl");
        assertEquals(expected.get(0).getImageLocation(), "www.slslsl");
    }

    @Test
    public void setCategoryID() {
        expected.add(product);
        expected.get(0).setCategoryID(4);
        assertEquals(expected.get(0).getCategoryID(), 4);
    }

    @Test
    public void getQuantity() {
        expected.add(product);
        expected.get(0).getQuantity();
        assertEquals(expected.get(0).getQuantity(), 5);
    }

    @Test
    public void setQuantity() {
        expected.add(product);
        expected.get(0).setQuantity(45);
        assertEquals(expected.get(0).getQuantity(), 45);
    }

    @Test
    public void isOnSale() {
        expected.add(product);
        expected.get(0).isOnSale();
        assertEquals(expected.get(0).isOnSale(), false);
    }

    @Test
    public void setOnSale() {
        expected.add(product);
        expected.get(0).setOnSale(false);
        assertEquals(expected.get(0).isOnSale(), false);
    }

    @Test
    public void getDescription() {
        expected.add(product);
        expected.get(0).getDescription();
        assertEquals(expected.get(0).getDescription(), "shitty");
    }

    @Test
    public void setDescription() {
        expected.add(product);
        expected.get(0).setDescription("notGood");
        assertEquals(expected.get(0).getDescription(), "notGood");

    }

    @Test
    public void setPurchasedQuantity() {
        expected.add(product);
        expected.get(0).setPurchasedQuantity(2);
        assertEquals(expected.get(0).getPurchasedQuantity(),2) ;
    }

    @Test
    public void getPurchasedQuantity() {
        expected.add(product);
        expected.get(0).getPurchasedQuantity();
        assertEquals(expected.get(0).getPurchasedQuantity(),2) ;
    }

    @Test
    public void getPrice() {
        expected.add(product);
        expected.get(0).getPrice();
        assertEquals(expected.get(0).getPrice(), 0);
    }

    @Test
    public void setPrice() {
        expected.add(product);
        expected.get(0).setPrice(200);
        assertEquals(expected.get(0).getPrice(),200) ;
    }
}