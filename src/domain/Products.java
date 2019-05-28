package domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Products implements Serializable {

    private ArrayList<Product> products;

    public Products(int amount) {
        products = new ArrayList(amount);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProduct(int index) {
        return products.get(index);
    }

    public Product getProduct(Product product){
        int index = products.indexOf(product);

        return products.get(index);
    }

    public int size(){
        return products.size();
    }


}
