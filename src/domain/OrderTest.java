package domain;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class OrderTest {

    private ShoppingBag bag = new ShoppingBag();
    private Order order = new Order(bag, "Peter", "1st Street", 1234);

    @org.junit.Test
    public void getShoppingBag() {
        assertEquals(bag, order.getShoppingBag());
    }


    @org.junit.Test
    public void getOrderID() {
        assertNotNull(order.getOrderID());
    }

    @org.junit.Test
    public void setOrderID() { }

    @org.junit.Test
    public void getCostumerName() {
        assertEquals("Peter", order.getCostumerName());
    }

    @org.junit.Test
    public void getAdress() {
        assertEquals("1st Street", order.getAdress());
    }

    @org.junit.Test
    public void getPhone() {
        assertEquals(1234, order.getPhone());
    }
}