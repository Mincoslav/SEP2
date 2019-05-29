package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArchiveTest {

    private Archive archive = new Archive(2);
    ShoppingBag bag = new ShoppingBag();
    private Order order = new Order(bag, "Samantha", "1st Street", 1234);
    private Order order2 = new Order(bag, "Tom", "2nd Street", 5678);

    @Test
    public void addOrderToArchive() {
        archive.addOrderToArchive(order);
        assertEquals(1, archive.size());
    }

    @Test
    public void getOrderFromArchive()
    {
        archive.addOrderToArchive(order);
        assertEquals(order, archive.getOrderFromArchive(0));
    }

    @Test
    public void removeOrderFromArchive() {
        archive.addOrderToArchive(order);
        archive.removeOrderFromArchive(order);
        assertEquals(0, archive.size());
    }

    @Test
    public void size() {
        archive.addOrderToArchive(order);
        archive.addOrderToArchive(order2);
        assertEquals(2, archive.size());
    }

    @Test
    public void isEmpty() {
        assertEquals(true, archive.isEmpty());
    }

    @Test
    public void getOrders() {
        archive.addOrderToArchive(order);
        assertEquals(order, archive.getOrders());

        // ?
    }
}