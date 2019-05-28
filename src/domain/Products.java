package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Products implements Serializable {

    private List<Product> products;

    public Products() {
        products = new ArrayList();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(Product product){
        products.remove(product);
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
