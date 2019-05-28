package domain;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class ShoppingBagTest {

    Product product1 = new Product("Tshirt", "www.com", 2,0,2 ,5, false, "shitty", 2);
    Product product0 = new Product("bluse", "www.", 30,0, 3,100, true, "cool", 12);
    List<Product> expected = new ArrayList<Product>();
    ShoppingBag bag = new ShoppingBag();

    @Test
    public void addProduct() {


        bag.addProduct(product1);
        assertEquals(bag.getProduct(0), product1);



    }

    @Test
    public void removeProduct() {

        bag.addProduct(product1);
        bag.removeProduct(product1);
        assertEquals(bag.size(), 0);
    }

    @Test
    public void size() {

        bag.addProduct(product1);
        assertEquals(bag.size(), 1);

    }

    @Test
    public void getProduct(){

        bag.addProduct(product1);
        assertEquals(bag.getProduct(0), product1 );

    }
    @Test
    public  void changeQuantity(){
        bag.addProduct(product1);
        bag.changeQuantity(0,4);
        assertEquals(bag.getProduct(0).getPurchasedQuantity(), 4);

    }


}