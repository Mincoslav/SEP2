package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Archive implements Serializable {

    private List<Order> orders;



    public Archive(int capacity) {
        orders = new ArrayList<>(capacity);
    }

    public void addOrderToArchive(Order order){
        orders.add(order);
    }

    public Order getOrderFromArchive(int index){
        return orders.get(index);
    }

    public void removeOrderFromArchive(Order order){
        orders.remove(order);
    }

    public int size(){
        return orders.size();
    }

    public boolean isEmpty(){
        return orders.isEmpty();
    }





    public List<Order> getOrders() {
        return orders;
    }
}
