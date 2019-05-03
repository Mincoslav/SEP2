package domain;

import java.util.ArrayList;

public class Archive {

    private ArrayList<Order> orders;



    public Archive(int capacity) {
        orders = new ArrayList<>(capacity);
    }

    public void addOrderToArchive(Order order){
        orders.add(order);
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





    public ArrayList<Order> getOrders() {
        return orders;
    }
}
